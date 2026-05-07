package com.federation.repository;

import com.federation.datasource.DataSource;
import com.federation.entities.Collectivity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.*;

@Repository @RequiredArgsConstructor @Slf4j
public class CollectivityRepository {
    private final DataSource ds;
    public List<Collectivity> findAll() {
        List<Collectivity> l = new ArrayList<>();
        try (Connection c = ds.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT id, name, number, location, specialization, president_id, vice_president_id, treasurer_id, secretary_id FROM collectivity")) {
            while (rs.next()) {
                Collectivity co = new Collectivity();
                co.setId(rs.getString("id"));
                co.setName(rs.getString("name"));
                co.setNumber(rs.getInt("number"));
                co.setLocation(rs.getString("location"));
                co.setSpecialization(rs.getString("specialization"));
                co.setPresidentId(rs.getString("president_id"));
                co.setVicePresidentId(rs.getString("vice_president_id"));
                co.setTreasurerId(rs.getString("treasurer_id"));
                co.setSecretaryId(rs.getString("secretary_id"));
                l.add(co);
            }
        } catch (Exception e) {
            log.error("Erreur lors de la récupération des collectivités", e);
            throw new RuntimeException("Erreur lors de la récupération des collectivités: " + e.getMessage(), e);
        }
        return l;
    }
}
