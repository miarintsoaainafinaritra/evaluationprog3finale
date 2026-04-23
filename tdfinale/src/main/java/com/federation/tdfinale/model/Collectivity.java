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
public class Collectivity {
    private String id;
    private String officialNumber;
    private String uniqueName;
    private String location;
    private String specialty;
    private LocalDate creationDate;
    private CollectivityStructure structure;
    private List<Member> members = new ArrayList<>();

    public void setMembers(List<Member> members) {
        this.members = members == null ? new ArrayList<>() : members;
    }
}