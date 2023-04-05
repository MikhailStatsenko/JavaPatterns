package com.pw18.pw18.service;

import com.pw18.pw18.model.Building;
import com.pw18.pw18.repository.AddressRepository;
import com.pw18.pw18.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final AddressRepository addressRepository;
    @Autowired
    public BuildingService(BuildingRepository buildingRepository, AddressRepository addressRepository) {
        this.buildingRepository = buildingRepository;
        this.addressRepository = addressRepository;
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public void addEntity(Building building, long address_id) {
        addressRepository.findById(address_id).ifPresent(address -> address.addBuildingToAddress(building));
        buildingRepository.save(building);
    }

    public void deleteEntity(String creationDate, String type) {
        List<Building> toDelete = buildingRepository.findByCreationDateAndType(creationDate, type);
        buildingRepository.deleteAll(toDelete);
    }

    public List<Building> sortBuildingsOrderedByCreationDate() {
        return buildingRepository.findAllSortedByDateAsc();
    }

    public List<Building> filterBuildingsByType(String type) {
        return buildingRepository.findByType(type);
    }
}
