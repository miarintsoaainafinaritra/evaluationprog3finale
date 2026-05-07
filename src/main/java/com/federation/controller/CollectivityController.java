package com.federation.controller;

import com.federation.entities.Collectivity;
import com.federation.repository.CollectivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/collectivities") @RequiredArgsConstructor
public class CollectivityController {
    private final CollectivityRepository repo;
    @GetMapping public List<Collectivity> findAll() { return repo.findAll(); }
}
