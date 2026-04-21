package com.federation.tdfinale.model;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCollectivity {
    private String name;
    private String location;
    private String specialty;
    private List<String> members;
    private boolean federationApproval;
    private CreateCollectivityStructure structure;
}
