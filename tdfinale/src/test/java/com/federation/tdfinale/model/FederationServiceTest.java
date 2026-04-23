package com.federation.tdfinale.model;

import com.federation.tdfinale.repository.FederationRepository;
import com.federation.tdfinale.service.FederationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FederationServiceTest {
    private FederationRepository repo;
    private FederationService service;

    @BeforeEach
    void setUp() {
        repo = new FederationRepository();
        service = new FederationService(repo);
    }

    @Test
    void createCollectivity_ShouldFail_WhenLessThen10Members() {
        var req = new CreateCollectivity("C1", "Tana", "Riziculture", Collections.emptyList(), true, null);
        assertThrows(RuntimeException.class, () -> service.createCollectivityList(List.of(req)));
    }

    @Test
    void createMember_ShouldFail_WhenNoSponsors() {
        var req = new CreateMember();
        req.setRegistrationFeePaid(true);
        req.setMembershipDuesPaid(true);
        req.setCollectivityIdentifier("C1");
        req.setReferees(Collections.emptyList());
        req.setRefereeRelationshipNature(Collections.emptyMap());
        assertThrows(RuntimeException.class, () -> service.createMembers(List.of(req)));
    }

    @Test
    void createMember_ShouldSucceed_WithCorrectSponsors() {
        var memberIds = seedMembers();
        var structure = new CreateCollectivityStructure(memberIds.get(0), memberIds.get(1), memberIds.get(2), memberIds.get(3));
        var collectivity = service.createCollectivityList(List.of(new CreateCollectivity("C1", "Tana", "Riziculture", memberIds, true, structure))).get(0);
        var request = buildValidCreateMember(collectivity.getId(), memberIds.get(0), memberIds.get(1));
        List<Member> created = service.createMembers(List.of(request));
        assertEquals(1, created.size());
        assertEquals("New", created.get(0).getFirstName());
    }

    private List<String> seedMembers() {
        repo.saveMember(member("M1", Gender.MALE));
        repo.saveMember(member("M2", Gender.FEMALE));
        var ids = new ArrayList<String>();
        IntStream.range(0, 10).forEach(i -> {
            String id = "MX" + i;
            repo.saveMember(member(id, Gender.MALE));
            ids.add(id);
        });
        return ids;
    }

    private Member member(String id, Gender gender) {
        return new Member(id, "N", "L", LocalDate.of(1990, 1, 1), gender, "Addr", "Job", 1, id + "@m.com", MemberOccupation.SENIOR, LocalDate.now().minusMonths(7), Collections.emptyList());
    }

    private CreateMember buildValidCreateMember(String collectivityId, String ref1, String ref2) {
        var req = new CreateMember();
        req.setFirstName("New"); req.setLastName("Member"); req.setBirthDate(LocalDate.of(2000, 1, 1)); req.setGender(Gender.MALE);
        req.setOccupation(MemberOccupation.JUNIOR); req.setCollectivityIdentifier(collectivityId); req.setRegistrationFeePaid(true); req.setMembershipDuesPaid(true);
        req.setReferees(List.of(ref1, ref2)); req.setRefereeRelationshipNature(java.util.Map.of(ref1, "famille", ref2, "ami"));
        return req;
    }
}
