package com.federation.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class CollectivityStatisticsDTO {
    private String collectivityName;
    private double upToDatePercentage;
    private int newMembersCount;
    private double averageAttendanceRate;
}
