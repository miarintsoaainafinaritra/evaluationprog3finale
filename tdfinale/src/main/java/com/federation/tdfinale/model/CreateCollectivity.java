package com.federation.tdfinale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCollectivity {
    private String id;
    private String location;
    private String specialty;
    private List<String> members = new ArrayList<>();
    private boolean federationApproval;
    private CreateCollectivityStructure structure;

    public void setMembers(List<String> members) {
        this.members = members == null ? new ArrayList<>() : members;
    }
}

