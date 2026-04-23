package com.federation.tdfinale.controller;

import com.federation.tdfinale.model.Collectivity;
import com.federation.tdfinale.model.CreateCollectivity;
import com.federation.tdfinale.model.CreateMember;
import com.federation.tdfinale.model.FinancialAccount;
import com.federation.tdfinale.model.Member;
import com.federation.tdfinale.service.FederationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FederationController {
    private final FederationService federationService;

    @PostMapping("/collectivities")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Collectivity> createCollectivities(@RequestBody List<CreateCollectivity> request) {
        return federationService.createCollectivityList(request);
    }

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Member> createMembers(@RequestBody List<CreateMember> request) {
        return federationService.createMembers(request);
    }

    @GetMapping("/collectivities/{id}")
    public Collectivity getCollectivityById(@PathVariable String id) {
        return federationService.getCollectivityById(id);
    }

    @GetMapping("/collectivities/{id}/financialAccounts")
    public List<FinancialAccount> getCollectivityFinancialAccounts(
        @PathVariable("id") String id,
        @RequestParam(name = "at", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate at
    ) {
        return federationService.getCollectivityFinancialAccounts(id, at);
    }
}
