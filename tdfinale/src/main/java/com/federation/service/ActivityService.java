package com.federation.service;

import com.federation.dto.AttendanceDTO;
import com.federation.entities.*;
import com.federation.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository ar;
    private final AttendanceRepository atr;
    public List<Activity> getActivities(String n) { return ar.findByCollectivity(n); }
    public void addActivities(String n, List<Activity> l) { for (Activity a : l) ar.save(a, n); }
    public List<Attendance> getAttendance(String t) { return atr.findByActivity(t, "PRESENT"); }
    public void markAttendance(String t, List<AttendanceDTO> l) {
        for (AttendanceDTO d : l) {
            if (!atr.exists(t, d.getMemberId())) {
                Attendance at = new Attendance();
                at.setStatus(d.getStatus());
                atr.save(at, t, d.getMemberId());
            }
        }
    }
}
