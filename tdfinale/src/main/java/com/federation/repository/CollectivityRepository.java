package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Collectivity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository @RequiredArgsConstructor
public class CollectivityRepository {
    private final DataSource ds;
    public List<Collectivity> findAll() {
        List<Collectivity> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT * FROM collectivity")) {
            while (rs.next()) {
                Collectivity co = new Collectivity();
                co.setId(rs.getString("id")); co.setName(rs.getString("name")); co.setNumber(rs.getInt("number"));
                co.setLocation(rs.getString("location")); co.setSpecialization(rs.getString("specialization"));
                co.setPresidentId(rs.getString("president_id")); co.setVicePresidentId(rs.getString("vice_president_id"));
                co.setTreasurerId(rs.getString("treasurer_id")); co.setSecretaryId(rs.getString("secretary_id"));
                l.add(co);
            }
        } catch (Exception e) { throw new RuntimeException(e); }
        return l;
    }
}
