package com.federation.controller;

import com.federation.entities.Collectivity;
import com.federation.repository.CollectivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/collectivities") @RequiredArgsConstructor
public class CollectivityController {
    private final CollectivityRepository repo;
    @GetMapping public List<Collectivity> findAll() { return repo.findAll(); }
    @PostMapping public void save(@RequestBody Collectivity c) { repo.save(c); }
    @PutMapping("/{id}") public void update(@PathVariable String id, @RequestBody Collectivity c) { c.setId(id); repo.update(c); }
}
