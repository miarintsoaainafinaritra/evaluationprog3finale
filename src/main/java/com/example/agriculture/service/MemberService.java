package com.example.agriculture.service;

import com.example.agriculture.Exception.NotFoundException;
import com.example.agriculture.Model.Collectivity;
import com.example.agriculture.Model.CreateMember;
import com.example.agriculture.Model.Member;
import com.example.agriculture.Repository.CollectivityRepository;
import com.example.agriculture.Repository.MemberRepository;
import com.example.agriculture.service.Factory.MemberFactory;
import com.example.agriculture.service.Validator.MemberValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final CollectivityRepository collectivityRepository;
    private final MemberValidator memberValidator;
    private final MemberFactory memberFactory;

    public MemberService(
            MemberRepository memberRepository,
            CollectivityRepository collectivityRepository,
            MemberValidator memberValidator,
            MemberFactory memberFactory
    ) {
        this.memberRepository = memberRepository;
        this.collectivityRepository = collectivityRepository;
        this.memberValidator = memberValidator;
        this.memberFactory = memberFactory;
    }

    public List<Member> createAll(List<CreateMember> inputs) {
        List<Member> results = new ArrayList<Member>();

        for (CreateMember input : inputs) {
            Collectivity targetCollectivity = findCollectivityByIdOrThrow(input.getCollectivityIdentifier());

            List<Member> referees = new ArrayList<Member>();
            if (input.getRefereeIds() != null) {
                for (String refereeId : input.getRefereeIds()) {
                    referees.add(findMemberByIdOrThrow(refereeId));
                }
            }

            memberValidator.validate(input, targetCollectivity, referees);

            Member member = memberFactory.create(input, targetCollectivity, referees);
            Member saved = memberRepository.save(member);

            results.add(saved);
        }

        return results;
    }

    private Collectivity findCollectivityByIdOrThrow(String collectivityId) {
        Collectivity collectivity = collectivityRepository.findById(collectivityId);
        if (collectivity == null) {
            throw new NotFoundException("Collectivity not found: " + collectivityId);
        }
        return collectivity;
    }

    private Member findMemberByIdOrThrow(String memberId) {
        Member member = memberRepository.findById(memberId);
        if (member == null) {
            throw new NotFoundException("Member not found: " + memberId);
        }
        return member;
    }
}