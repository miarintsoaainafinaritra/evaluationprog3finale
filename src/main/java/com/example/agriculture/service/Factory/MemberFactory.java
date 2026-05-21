package com.example.agriculture.service.Factory;

import com.example.agriculture.Model.Collectivity;
import com.example.agriculture.Model.CreateMember;
import com.example.agriculture.Model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberFactory {

    public Member create(CreateMember input, Collectivity collectivity, List<Member> referees) {
        return new Member(
                null,
                input.getFirstName(),
                input.getLastName(),
                input.getBirthDate(),
                input.getGender(),
                input.getAddress(),
                input.getProfession(),
                input.getPhone(),
                input.getEmail(),
                input.getOccupation(),
                collectivity,
                referees
        );
    }
}
