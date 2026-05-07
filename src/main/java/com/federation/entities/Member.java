package com.federation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String address;
    private String profession;
    private String phoneNumber;
    private String email;
    private String occupation;
    private LocalDate membershipDate;
    private boolean registrationFeePaid;
    private boolean membershipDuesPaid;
}
