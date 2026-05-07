package com.federation.service;

import com.federation.dto.*;
import com.federation.entities.*;
import com.federation.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service @RequiredArgsConstructor
public class StatisticsService {
    private final CollectivityRepository cr;
    private final MemberRepository mr;
    private final FeeRepository fr;
    private final PaymentRepository pr;
    private final ActivityRepository ar;
    private final AttendanceRepository atr;

    public List<MemberStatisticsDTO> getCollectivityStats(String n, LocalDate f, LocalDate t) {
        List<MemberStatisticsDTO> res = new ArrayList<>();
        double tf = 0;
        for (MembershipFee fee : fr.findActiveByCollectivity(n)) tf += fee.getAmount();
        int as = 0;
        for (Activity a : ar.findByCollectivity(n)) if (!a.getDate().isBefore(f) && !a.getDate().isAfter(t)) as++;
        for (Member m : mr.findByCollectivity(n)) {
            double p = 0;
            for (Payment pay : pr.findByMember(m.getFirstName(), m.getLastName())) p += pay.getAmount();
            int c = 0;
            for (Attendance at : atr.findByMember(m.getFirstName(), m.getLastName(), f, t)) if ("PRESENT".equals(at.getStatus())) c++;
            res.add(new MemberStatisticsDTO(m.getFirstName()+" "+m.getLastName(), p, Math.max(0, tf-p), as == 0 ? 0 : (double) c/as*100));
        }
        return res;
    }

    public List<CollectivityStatisticsDTO> getFederationStats(LocalDate f, LocalDate t) {
        List<CollectivityStatisticsDTO> res = new ArrayList<>();
        for (Collectivity c : cr.findAll()) {
            List<MemberStatisticsDTO> ms = getCollectivityStats(c.getName(), f, t);
            int up = 0; double att = 0;
            for (MemberStatisticsDTO s : ms) {
                if (s.getOutstandingAmount() <= 0) up++;
                att += s.getAttendanceRate();
            }
            res.add(new CollectivityStatisticsDTO(c.getName(), ms.isEmpty() ? 0 : (double) up/ms.size()*100, mr.findNew(c.getName(), f).size(), ms.isEmpty() ? 0 : att/ms.size()));
        }
        return res;
    }
}
