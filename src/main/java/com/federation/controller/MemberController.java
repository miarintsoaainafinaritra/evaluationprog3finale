package com.federation.controller;

import com.federation.entities.Member;
import com.federation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/members") @RequiredArgsConstructor
public class MemberController {
    private final MemberRepository repo;
    @GetMapping public List<Member> findAll() { return repo.findAll(); }
    @GetMapping("/by-collectivity/{name}") public List<Member> findByColl(@PathVariable String name) { return repo.findByCollectivity(name); }
}
