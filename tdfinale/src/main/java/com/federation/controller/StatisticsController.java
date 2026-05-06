package com.federation.controller;

import com.federation.dto.CollectivityStatisticsDTO;
import com.federation.dto.MemberStatisticsDTO;
import com.federation.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService service;

    @GetMapping("/collectivites/{name}/statistics")
    public List<MemberStatisticsDTO> getStats(@PathVariable String name, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return service.getCollectivityStats(name, from, to);
    }

    @GetMapping("/collectivites/statistics")
    public List<CollectivityStatisticsDTO> getFedStats(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return service.getFederationStats(from, to);
    }
}
