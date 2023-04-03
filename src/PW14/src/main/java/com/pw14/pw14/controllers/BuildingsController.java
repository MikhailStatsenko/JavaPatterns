package com.pw14.pw14.controllers;

import com.pw14.pw14.Classes.Building;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/buildings")
public class BuildingsController {
    private List<Building> buildingsList = new ArrayList<>();

    @GetMapping("/")
    @ResponseBody
    public List<Building> showBuildings() {
        return buildingsList;
    }

    @GetMapping("/add")
    public String addBuilding(@RequestParam("creationDate") String creationDate,
                             @RequestParam("type") String type) {
        buildingsList.add(new Building(creationDate, type));
        return "redirect:/buildings/";
    }

    @GetMapping("/delete")
    public String deleteBuilding(@RequestParam("creationDate") String creationDate,
                                @RequestParam("type") String type) {
        for (Building building : buildingsList) {
            if (building.getCreationDate().equals(creationDate) && building.getType().equals(type)) {
                buildingsList.remove(building);
                return "redirect:/buildings/";
            }
        }

        return "redirect:/buildings/";
    }

}
