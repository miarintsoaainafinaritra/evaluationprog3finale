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

    public void save(Collectivity c) {
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO collectivity (id, name, number, location, specialization, president_id, vice_president_id, treasurer_id, secretary_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, c.getId()); ps.setString(2, c.getName()); ps.setInt(3, c.getNumber());
            ps.setString(4, c.getLocation()); ps.setString(5, c.getSpecialization());
            ps.setString(6, c.getPresidentId()); ps.setString(7, c.getVicePresidentId());
            ps.setString(8, c.getTreasurerId()); ps.setString(9, c.getSecretaryId());
            ps.executeUpdate();
        } catch (Exception e) { 
            log.error("Erreur lors de la création de la collectivité: {}", c.getId(), e);
            throw new RuntimeException(e); 
        }
    }

    public void update(Collectivity c) {
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE collectivity SET name=?, number=?, location=?, specialization=?, president_id=?, vice_president_id=?, treasurer_id=?, secretary_id=? WHERE id=?")) {
            ps.setString(1, c.getName()); ps.setInt(2, c.getNumber());
            ps.setString(3, c.getLocation()); ps.setString(4, c.getSpecialization());
            ps.setString(5, c.getPresidentId()); ps.setString(6, c.getVicePresidentId());
            ps.setString(7, c.getTreasurerId()); ps.setString(8, c.getSecretaryId());
            ps.setString(9, c.getId());
            ps.executeUpdate();
        } catch (Exception e) { 
            log.error("Erreur lors de la mise à jour de la collectivité: {}", c.getId(), e);
            throw new RuntimeException(e); 
        }
    }
}
