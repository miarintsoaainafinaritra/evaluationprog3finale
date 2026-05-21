package com.example.agriculture.Repository;

import com.example.agriculture.Model.MembershipFee;
import java.util.List;

public interface MembershipFeeRepository {
    MembershipFee save(String collectivityId, MembershipFee membershipFee);
    List<MembershipFee> findByCollectivityId(String collectivityId);
}