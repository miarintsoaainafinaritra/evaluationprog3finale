package com.federation.controller;

import com.federation.dto.AttendanceDTO;
import com.federation.entities.Activity;
import com.federation.entities.Attendance;
import com.federation.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/collectivities/{name}/activities") @RequiredArgsConstructor
public class ActivityController {
    private final ActivityService service;
    @GetMapping public List<Activity> get(@PathVariable String name) { return service.getActivities(name); }
    @PostMapping public void post(@PathVariable String name, @RequestBody List<Activity> list) { service.addActivities(name, list); }
    @GetMapping("/{title}/attendance") public List<Attendance> getAt(@PathVariable String title) { return service.getAttendance(title); }
    @PostMapping("/{title}/attendance") public void postAt(@PathVariable String title, @RequestBody List<AttendanceDTO> list) { service.markAttendance(title, list); }
}
