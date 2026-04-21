package com.federation.tdfinale.model;

import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<String> referees;
    private Map<String, String> refereeRelationshipNature;
    private boolean registrationFeePaid;
    private boolean membershipDuesPaid;
}
