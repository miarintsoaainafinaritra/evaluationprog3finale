package com.example.agriculture.Repository;

import com.example.agriculture.Model.Member;
import java.util.List;

public interface MemberRepository {
    Member findById(String id);
    Member save(Member member);
    List<Member> findByCollectivityId(String collectivityId);
}