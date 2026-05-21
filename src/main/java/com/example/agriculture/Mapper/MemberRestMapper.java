package com.example.agriculture.Mapper;

import com.example.agriculture.Endpoint.MemberRest;
import com.example.agriculture.Model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberRestMapper {

    public MemberRest toRest(Member member) {
        MemberRest rest = new MemberRest();

        rest.setId(member.getId());
        rest.setFirstName(member.getFirstName());
        rest.setLastName(member.getLastName());
        rest.setBirthDate(member.getBirthDate());
        rest.setGender(member.getGender());
        rest.setAddress(member.getAddress());
        rest.setProfession(member.getProfession());
        rest.setPhone(member.getPhone());
        rest.setEmail(member.getEmail());
        Member.setOccupation(11, member.getOccupation("occupation"));

        return rest;
    }
}