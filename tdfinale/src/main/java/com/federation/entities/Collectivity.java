package com.federation.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
