package com.federation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collectivity {
    private String id;
    private String name;
    private Integer number;
    private String location;
    private String specialization;
    private String presidentId;
    private String vicePresidentId;
    private String treasurerId;
    private String secretaryId;
}
