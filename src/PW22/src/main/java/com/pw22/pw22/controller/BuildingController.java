package com.pw22.pw22.controller;

import com.pw22.pw22.model.Building;
import com.pw22.pw22.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/buildings")
public class BuildingController {
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Building> showBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/add")
    public String addBuilding(@RequestParam String creationDate,
                             @RequestParam String type, @RequestParam long addressId) {
        buildingService.addEntity(new Building(creationDate, type), addressId);
        return "redirect:/buildings/";
    }


    @GetMapping("/delete")
    public String deleteBuilding(@RequestParam("creationDate") String creationDate,
                                @RequestParam("type") String type) {
        buildingService.deleteEntity(creationDate, type);
        return "redirect:/buildings/";
    }

    @GetMapping("/sorted_by_creation_date")
    @ResponseBody
    public String showBuildingsOrderedByCreationDate() {
        return buildingService.sortBuildingsOrderedByCreationDate().toString();
    }

    @GetMapping("/{type}")
    @ResponseBody
    public String showBuildingsByType(@PathVariable String type) {
        return  buildingService.filterBuildingsByType(type).toString();
    }
}

