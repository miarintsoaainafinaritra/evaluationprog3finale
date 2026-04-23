package com.federation.tdfinale.service;

import com.federation.tdfinale.model.Collectivity;
import com.federation.tdfinale.model.CreateCollectivity;
import com.federation.tdfinale.model.CreateMember;
import com.federation.tdfinale.model.FinancialAccount;
import com.federation.tdfinale.model.Member;
import com.federation.tdfinale.repository.FederationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FederationService {
    private final FederationRepository repository;

    public List<Collectivity> createCollectivityList(List<CreateCollectivity> requests) {
        List<Collectivity> created = new ArrayList<>();
        for (CreateCollectivity request : requests) {
            validateCollectivityRequest(request);
            repository.saveCollectivity(request);
            Collectivity collectivity = repository.findCollectivityById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Collectivity creation failed"));
            created.add(collectivity);
        }
        return created;
    }

    public List<Member> createMembers(List<CreateMember> requests) {
        List<Member> created = new ArrayList<>();
        for (CreateMember request : requests) {
            validateCreateMemberRequest(request);
            Member member = buildMember(request);

            repository.saveMember(member);
            repository.attachMemberToCollectivity(request.getCollectivityIdentifier(), member.getId());

            for (Map.Entry<String, String> entry : request.getRefereeRelationshipNature().entrySet()) {
                repository.saveMemberReferee(member.getId(), entry.getKey(), entry.getValue());
            }

            created.add(member);
        }
        return created;
    }

    public Collectivity getCollectivityById(String id) {
        return repository.findCollectivityById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Collectivity not found"));
    }

    public List<FinancialAccount> getCollectivityFinancialAccounts(String collectivityId, LocalDate at) {
        if (repository.isUnknownCollectivity(collectivityId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collectivity not found");
        }
        return repository.findFinancialAccounts(collectivityId);
    }

    private void validateCollectivityRequest(CreateCollectivity request) {
        if (!request.isFederationApproval()) {
            throw new RuntimeException("Collectivity without federation approval");
        }
        if (request.getStructure() == null) {
            throw new RuntimeException("Collectivity structure is required");
        }
        if (request.getMembers() == null || request.getMembers().size() < 10) {
            throw new RuntimeException("A collectivity must have at least 10 members");
        }
        for (String memberId : request.getMembers()) {
            if (repository.findMemberById(memberId).isEmpty()) {
                throw new RuntimeException("Member not found: " + memberId);
            }
        }
    }

    private void validateCreateMemberRequest(CreateMember request) {
        if (!request.isRegistrationFeePaid() || !request.isMembershipDuesPaid()) {
            throw new RuntimeException("Required payments are not completed");
        }
        if (request.getReferees() == null || request.getReferees().size() < 2) {
            throw new RuntimeException("At least two referees are required");
        }
        if (repository.isUnknownCollectivity(request.getCollectivityIdentifier())) {
            throw new RuntimeException("Collectivity not found");
        }

        LocalDate threshold = LocalDate.now().minusMonths(6);
        for (String refereeId : request.getReferees()) {
            Member referee = repository.findMemberById(refereeId).orElse(null);
            if (referee == null) {
                throw new RuntimeException("Referee not found: " + refereeId);
            }
            if (referee.getAdhesionDate() == null || referee.getAdhesionDate().isAfter(threshold)) {
                throw new RuntimeException("Referee must have at least 6 months seniority: " + refereeId);
            }
        }
    }

    private Member buildMember(CreateMember request) {
        Member member = new Member();
        member.setId("M-" + UUID.randomUUID().toString().substring(0, 8));
        member.setFirstName(request.getFirstName());
        member.setLastName(request.getLastName());
        member.setBirthDate(request.getBirthDate());
        member.setGender(request.getGender());
        member.setAddress(request.getAddress());
        member.setProfession(request.getProfession());
        member.setPhoneNumber(request.getPhoneNumber());
        member.setEmail(request.getEmail());
        member.setOccupation(request.getOccupation());
        member.setAdhesionDate(LocalDate.now());
        return member;
    }
}
