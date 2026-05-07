package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository @RequiredArgsConstructor @Slf4j
public class MemberRepository {
    private final DataSource ds;
    public List<Member> findAll() {
        List<Member> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT * FROM member")) {
            while (rs.next()) l.add(map(rs));
        } catch (Exception e) { 
            log.error("Erreur lors de la récupération de tous les membres", e);
            throw new RuntimeException(e); 
        }
        return l;
    }
    public List<Member> findByCollectivity(String n) {
        List<Member> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT m.* FROM member m JOIN collectivity_member cm ON m.id = cm.member_id JOIN collectivity col ON cm.collectivity_id = col.id WHERE col.name=?")) {
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) l.add(map(rs));
        } catch (Exception e) { 
            log.error("Erreur lors de la récupération des membres pour la collectivité: {}", n, e);
            throw new RuntimeException(e); 
        }
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
    public void save(Member m) {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, membership_date, registration_fee_paid, membership_dues_paid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, m.getId()); ps.setString(2, m.getFirstName()); ps.setString(3, m.getLastName());
            ps.setDate(4, m.getBirthDate() != null ? java.sql.Date.valueOf(m.getBirthDate()) : null);
            ps.setString(5, m.getGender()); ps.setString(6, m.getAddress()); ps.setString(7, m.getProfession());
            ps.setString(8, m.getPhoneNumber()); ps.setString(9, m.getEmail()); ps.setString(10, m.getOccupation());
            ps.setDate(11, m.getMembershipDate() != null ? java.sql.Date.valueOf(m.getMembershipDate()) : null);
            ps.setBoolean(12, m.isRegistrationFeePaid()); ps.setBoolean(13, m.isMembershipDuesPaid());
            ps.executeUpdate();
        } catch (Exception e) { 
            log.error("Erreur lors de la création du membre: {}", m.getId(), e);
            throw new RuntimeException(e); 
        }
    }
    public void update(Member m) {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE member SET first_name=?, last_name=?, birth_date=?, gender=?, address=?, profession=?, phone_number=?, email=?, occupation=?, membership_date=?, registration_fee_paid=?, membership_dues_paid=? WHERE id=?")) {
            ps.setString(1, m.getFirstName()); ps.setString(2, m.getLastName());
            ps.setDate(3, m.getBirthDate() != null ? java.sql.Date.valueOf(m.getBirthDate()) : null);
            ps.setString(4, m.getGender()); ps.setString(5, m.getAddress()); ps.setString(6, m.getProfession());
            ps.setString(7, m.getPhoneNumber()); ps.setString(8, m.getEmail()); ps.setString(10, m.getOccupation());
            ps.setDate(10, m.getMembershipDate() != null ? java.sql.Date.valueOf(m.getMembershipDate()) : null);
            ps.setBoolean(11, m.isRegistrationFeePaid()); ps.setBoolean(12, m.isMembershipDuesPaid());
            ps.setString(13, m.getId());
            ps.executeUpdate();
        } catch (Exception e) { 
            log.error("Erreur lors de la mise à jour du membre: {}", m.getId(), e);
            throw new RuntimeException(e); 
        }
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
