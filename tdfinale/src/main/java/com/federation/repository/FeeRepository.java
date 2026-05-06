package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.MembershipFee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository @RequiredArgsConstructor
public class FeeRepository {
    private final DataSource ds;
    public List<MembershipFee> findActiveByCollectivity(String n) {
        List<MembershipFee> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT amount FROM membership_fee f JOIN collectivity col ON f.collectivity_id = col.id WHERE col.name=? AND f.active=true")) {
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { MembershipFee f = new MembershipFee(); f.setAmount(rs.getDouble(1)); l.add(f); }
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
}
