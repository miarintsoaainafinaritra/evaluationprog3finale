package com.federation.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class MemberStatisticsDTO {
    private String memberName;
    private double totalPaid, outstandingAmount, attendanceRate;
}
