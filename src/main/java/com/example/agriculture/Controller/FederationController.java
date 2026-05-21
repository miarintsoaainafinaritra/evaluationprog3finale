package com.example.agriculture.Controller;

import com.example.agriculture.Mapper.CollectivityRestMapper;
import com.example.agriculture.Endpoint.CollectivityInformationRest;
import com.example.agriculture.Endpoint.CreateMembershipFeeRest;
import com.example.agriculture.Endpoint.MembershipFeeRest;
import com.example.agriculture.Model.Collectivity;
import com.example.agriculture.Model.CollectivityInformation;
import com.example.agriculture.Model.CreateMembershipFee;
import com.example.agriculture.Model.MembershipFee;
import com.example.agriculture.service.CollectivityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FederationController {

    private final CollectivityService collectivityService;
    private final CollectivityRestMapper collectivityRestMapper;

    public FederationController(
            CollectivityService collectivityService,
            CollectivityRestMapper collectivityRestMapper
    ) {
        this.collectivityService = collectivityService;
        this.collectivityRestMapper = collectivityRestMapper;
    }

    @PutMapping("/collectivities/{id}/informations")
    @ResponseStatus(HttpStatus.OK)
    public Collectivity updateCollectivityInformations(
            @PathVariable String id,
            @RequestBody CollectivityInformationRest request
    ) {
        CollectivityInformation info;

        info = collectivityRestMapper.toDomainInformation(request);

        return collectivityService.updateInformation(id, info);
    }

    @PostMapping("/collectivities/{id}/membershipFees")
    @ResponseStatus(HttpStatus.OK)
    public List<MembershipFeeRest> createMembershipFees(
            @PathVariable String id,
            @RequestBody List<CreateMembershipFeeRest> request
    ) {
        List<CreateMembershipFee> fees;
        List<MembershipFee> created;
        List<MembershipFeeRest> response;
        int i;

        fees = new ArrayList<CreateMembershipFee>();
        for (i = 0; i < request.size(); i++) {
            fees.add(collectivityRestMapper.toDomainCreateMembershipFee(request.get(i)));
        }

        created = collectivityService.createFees(id, fees);

        response = new ArrayList<MembershipFeeRest>();
        for (i = 0; i < created.size(); i++) {
            response.add(collectivityRestMapper.toMembershipFeeRest(created.get(i)));
        }

        return response;
    }

    @GetMapping("/collectivities/{id}/membershipFees")
    @ResponseStatus(HttpStatus.OK)
    public List<MembershipFeeRest> getMembershipFees(@PathVariable String id) {
        List<MembershipFee> fees;
        List<MembershipFeeRest> response;
        int i;

        fees = collectivityService.getFees(id);

        response = new ArrayList<MembershipFeeRest>();
        for (i = 0; i < fees.size(); i++) {
            response.add(collectivityRestMapper.toMembershipFeeRest(fees.get(i)));
        }

        return response;
    }
}