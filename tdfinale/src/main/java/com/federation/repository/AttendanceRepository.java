package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Attendance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository @RequiredArgsConstructor
public class AttendanceRepository {
    private final DataSource ds;
    public List<Attendance> findByActivity(String t, String s) {
        List<Attendance> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT status FROM attendance at JOIN activity a ON at.activity_id = a.id WHERE a.title=? AND at.status=?")) {
            ps.setString(1, t); ps.setString(2, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { Attendance a = new Attendance(); a.setStatus(rs.getString(1)); l.add(a); }
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
    public List<Attendance> findByMember(String fn, String ln, LocalDate s, LocalDate e) {
        List<Attendance> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT status FROM attendance at JOIN member m ON at.member_id = m.id JOIN activity a ON at.activity_id = a.id WHERE m.first_name=? AND m.last_name=? AND a.date BETWEEN ? AND ?")) {
            ps.setString(1, fn); ps.setString(2, ln); ps.setDate(3, java.sql.Date.valueOf(s)); ps.setDate(4, java.sql.Date.valueOf(e));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { Attendance a = new Attendance(); a.setStatus(rs.getString(1)); l.add(a); }
        } catch (Exception ex) { throw new RuntimeException(ex); }
        return l;
    }
    public boolean exists(String t, String mid) {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT 1 FROM attendance at JOIN activity a ON at.activity_id = a.id WHERE a.title=? AND at.member_id=?")) {
            ps.setString(1, t); ps.setString(2, mid);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }
    public void save(Attendance at, String t, String mid) {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO attendance (activity_id, member_id, status) SELECT id, ?, ? FROM activity WHERE title=?")) {
            ps.setString(1, mid); ps.setString(2, at.getStatus()); ps.setString(3, t);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
