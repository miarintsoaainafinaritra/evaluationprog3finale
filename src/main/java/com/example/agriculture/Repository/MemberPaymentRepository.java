package com.example.agriculture.Repository;

import com.example.agriculture.Model.MemberPayment;
import java.util.List;

public interface MemberPaymentRepository {

    void save(MemberPayment payment);

    List<MemberPayment> findByMemberId(String memberId);

    List<MemberPayment> saveAll(List<MemberPayment> payments);
}