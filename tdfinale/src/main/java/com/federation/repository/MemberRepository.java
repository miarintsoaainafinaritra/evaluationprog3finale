package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository @RequiredArgsConstructor
public class MemberRepository {
    private final DataSource ds;
    public List<Member> findAll() {
        List<Member> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT * FROM member")) {
            while (rs.next()) l.add(map(rs));
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
    public List<Member> findByCollectivity(String n) {
        List<Member> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT m.* FROM member m JOIN collectivity_member cm ON m.id = cm.member_id JOIN collectivity col ON cm.collectivity_id = col.id WHERE col.name=?")) {
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) l.add(map(rs));
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
    public List<Member> findNew(String n, LocalDate d) {
        List<Member> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT m.* FROM member m JOIN collectivity_member cm ON m.id = cm.member_id JOIN collectivity col ON cm.collectivity_id = col.id WHERE col.name=? AND m.membership_date>?")) {
            ps.setString(1, n); ps.setDate(2, java.sql.Date.valueOf(d));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) l.add(map(rs));
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
    private Member map(ResultSet rs) throws SQLException {
        Member m = new Member();
        m.setId(rs.getString("id")); m.setFirstName(rs.getString("first_name")); m.setLastName(rs.getString("last_name"));
        java.sql.Date b = rs.getDate("birth_date"); if (b != null) m.setBirthDate(b.toLocalDate());
        m.setGender(rs.getString("gender")); m.setAddress(rs.getString("address")); m.setProfession(rs.getString("profession"));
        m.setPhoneNumber(rs.getString("phone_number")); m.setEmail(rs.getString("email")); m.setOccupation(rs.getString("occupation"));
        java.sql.Date md = rs.getDate("membership_date"); if (md != null) m.setMembershipDate(md.toLocalDate());
        m.setRegistrationFeePaid(rs.getBoolean("registration_fee_paid")); m.setMembershipDuesPaid(rs.getBoolean("membership_dues_paid"));
        return m;
    }
}
