package com.federation.tdfinale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String profession;
    private Integer phoneNumber;
    private String email;
    private MemberOccupation occupation;
    private LocalDate adhesionDate;
    private List<Member> referees = new ArrayList<>();

    public void setReferees(List<Member> referees) {
        this.referees = referees == null ? new ArrayList<>() : referees;
    }
}
