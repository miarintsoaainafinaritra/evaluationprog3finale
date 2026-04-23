package com.federation.tdfinale.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateMember {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String profession;
    private Integer phoneNumber;
    private String email;
    private MemberOccupation occupation;
    private String collectivityIdentifier;
    private List<String> referees = new ArrayList<>();
    private Map<String, String> refereeRelationshipNature = new HashMap<>();
    private boolean registrationFeePaid;
    private boolean membershipDuesPaid;

    public void setReferees(List<String> referees) {
        this.referees = referees == null ? new ArrayList<>() : referees;
    }

    public void setRefereeRelationshipNature(Map<String, String> refereeRelationshipNature) {
        this.refereeRelationshipNature = refereeRelationshipNature == null ? new HashMap<>() : refereeRelationshipNature;
    }
}
