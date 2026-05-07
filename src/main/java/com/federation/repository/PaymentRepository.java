package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository @RequiredArgsConstructor
public class PaymentRepository {
    private final DataSource ds;
    public List<Payment> findByMember(String fn, String ln) {
        List<Payment> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT amount, payment_date FROM payment p JOIN member m ON p.member_id = m.id WHERE m.first_name=? AND m.last_name=?")) {
            ps.setString(1, fn); ps.setString(2, ln);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Payment p = new Payment();
                p.setAmount(rs.getDouble(1)); 
                Timestamp ts = rs.getTimestamp(2);
                if (ts != null) {
                    p.setPaymentDate(ts.toLocalDateTime());
                }
                l.add(p);
            }
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
}
