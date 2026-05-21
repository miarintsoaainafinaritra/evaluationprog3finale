package com.example.agriculture.service.Factory;

import com.example.agriculture.Model.Collectivity;
import com.example.agriculture.Model.CollectivityStructure;
import com.example.agriculture.Model.CreateCollectivity;
import com.example.agriculture.Model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectivityFactory {

    public Collectivity create(CreateCollectivity input, List<Member> members,
                               Member president, Member vicePresident,
                               Member treasurer, Member secretary) {

        Collectivity collectivity = new Collectivity();

        collectivity.setLocality(input.getLocation());
        collectivity.setMembers(members);
        collectivity.setNumber(Integer.parseInt(generateNumber()));
        collectivity.setName(generateName(input.getLocation()));

        CollectivityStructure structure = new CollectivityStructure();
        structure.setPresident(president);
        structure.setVicePresident(vicePresident);
        structure.setTreasurer(treasurer);
        structure.setSecretary(secretary);

        collectivity.setStructure(structure);

        return collectivity;
    }

    private String generateNumber() {
        return "COL-" + System.currentTimeMillis();
    }

    private String generateName(String location) {
        return "Collectivity-" + location + "-" + System.currentTimeMillis();
    }
}