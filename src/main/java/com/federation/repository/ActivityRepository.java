package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository @RequiredArgsConstructor
public class ActivityRepository {
    private final DataSource ds;
    public List<Activity> findByCollectivity(String n) {
        List<Activity> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT title, date FROM activity a JOIN collectivity col ON a.collectivity_id = col.id WHERE col.name=?")) {
            ps.setString(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { Activity a = new Activity(rs.getString(1), rs.getDate(2).toLocalDate()); l.add(a); }
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
    public void save(Activity a, String cid) {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO activity (title, date, collectivity_id) SELECT ?, ?, id FROM collectivity WHERE name=?")) {
            ps.setString(1, a.getTitle()); ps.setDate(2, java.sql.Date.valueOf(a.getDate())); ps.setString(3, cid);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
