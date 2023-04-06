package com.pw19.pw19.service;

import com.pw19.pw19.model.Building;
import com.pw19.pw19.repository.AddressRepository;
import com.pw19.pw19.repository.BuildingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final AddressRepository addressRepository;
    @Autowired
    public BuildingService(BuildingRepository buildingRepository, AddressRepository addressRepository) {
        this.buildingRepository = buildingRepository;
        this.addressRepository = addressRepository;
    }

    public List<Building> getAllBuildings() {
        log.info("Find all buildings");
        return buildingRepository.findAll();
    }

    public void addEntity(Building building, long address_id) {
        log.info("Saving building: {}", building);
        addressRepository.findById(address_id).ifPresent(address -> address.addBuildingToAddress(building));
        buildingRepository.save(building);
    }

    public void deleteEntity(String creationDate, String type) {
        log.info("Removing all buildings with creationDate = {} and type = {}", creationDate, type);
        List<Building> toDelete = buildingRepository.findByCreationDateAndType(creationDate, type);
        buildingRepository.deleteAll(toDelete);
    }

    public List<Building> sortBuildingsOrderedByCreationDate() {
        log.info("Getting all buildings sorted by creation date");
        return buildingRepository.findAllSortedByDateAsc();
    }

    public List<Building> filterBuildingsByType(String type) {
        log.info("Getting all buildings with type = {}", type);
        return buildingRepository.findByType(type);
    }
}
