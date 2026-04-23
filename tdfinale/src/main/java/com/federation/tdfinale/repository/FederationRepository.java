package com.federation.tdfinale.repository;

import com.federation.tdfinale.model.Collectivity;
import com.federation.tdfinale.model.CollectivityStructure;
import com.federation.tdfinale.model.CreateCollectivity;
import com.federation.tdfinale.model.FinancialAccount;
import com.federation.tdfinale.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FederationRepository {
    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, CollectivityData> collectivityById = new HashMap<>();
    private final Map<String, List<FinancialAccount>> accountByCollectivity = new HashMap<>();
    private final Map<String, List<String>> memberIdsByCollectivity = new HashMap<>();
    private final Map<String, Map<String, String>> refereeRelationships = new HashMap<>();

    public void saveMember(Member member) { members.put(member.getId(), member); }

    public Optional<Member> findMemberById(String memberId) { return Optional.ofNullable(members.get(memberId)); }

    public boolean isUnknownCollectivity(String collectivityId) { return !collectivityById.containsKey(collectivityId); }

    public void attachMemberToCollectivity(String collectivityId, String memberId) {
        memberIdsByCollectivity.computeIfAbsent(collectivityId, k -> new ArrayList<>()).add(memberId);
    }

    public void saveMemberReferee(String memberId, String refereeId, String relationshipNature) {
        Member member = members.get(memberId);
        Member referee = members.get(refereeId);
        if (member != null && referee != null) member.getReferees().add(referee);
        refereeRelationships.computeIfAbsent(memberId, k -> new HashMap<>()).put(refereeId, relationshipNature);
    }

    public void saveCollectivity(CreateCollectivity request) {
        CollectivityData data = new CollectivityData(request.getId(), request.getId(), request.getLocation(), request.getSpecialty(),
            request.getStructure().getPresident(), request.getStructure().getVicePresident(), request.getStructure().getTreasurer(), request.getStructure().getSecretary());
        collectivityById.put(data.id(), data);
        FinancialAccount cash = new FinancialAccount();
        cash.setId("FA-CASH-" + data.id());
        cash.setAccountType("CASH");
        cash.setHolderName(data.uniqueName());
        cash.setAmount(0.0d);
        accountByCollectivity.put(data.id(), new ArrayList<>(List.of(cash)));
        request.getMembers().forEach(id -> attachMemberToCollectivity(request.getId(), id));
    }

    public List<Member> findMembersByCollectivityId(String collectivityId) {
        return memberIdsByCollectivity.getOrDefault(collectivityId, Collections.emptyList()).stream()
            .map(members::get).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<FinancialAccount> findFinancialAccounts(String collectivityId) {
        return new ArrayList<>(accountByCollectivity.getOrDefault(collectivityId, Collections.emptyList()));
    }

    public Optional<Collectivity> findCollectivityById(String id) { return Optional.ofNullable(collectivityById.get(id)).map(this::toCollectivity); }

    private Collectivity toCollectivity(CollectivityData d) {
        return new Collectivity(d.id(), d.id(), d.uniqueName(), d.location(), d.specialty(), null,
            new CollectivityStructure(findMemberById(d.presidentId()).orElse(null), findMemberById(d.vicePresidentId()).orElse(null),
                findMemberById(d.treasurerId()).orElse(null), findMemberById(d.secretaryId()).orElse(null)),
            findMembersByCollectivityId(d.id()));
    }

    private record CollectivityData(String id, String uniqueName, String location, String specialty, String presidentId, String vicePresidentId, String treasurerId, String secretaryId) {}
}