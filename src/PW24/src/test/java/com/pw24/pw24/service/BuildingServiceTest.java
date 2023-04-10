package com.pw24.pw24.service;

import com.pw24.pw24.model.Address;
import com.pw24.pw24.model.Building;
import com.pw24.pw24.repository.AddressRepository;
import com.pw24.pw24.repository.BuildingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {
    private BuildingService buildingService;
    @Mock
    private BuildingRepository buildingRepository;

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        buildingService = new BuildingService(buildingRepository, addressRepository);
    }

    @Test
    public void testGetAllBuildings() {
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building());
        buildingList.add(new Building());
        Mockito.when(buildingRepository.findAll()).thenReturn(buildingList);
        List<Building> allBuildings = buildingService.getAllBuildings();
        assertThat(allBuildings).isEqualTo(buildingList);
    }

    @Test
    public void testAddEntity() {
        Building building = new Building();
        Address address = new Address();
        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(address));
        buildingService.addEntity(building, 1L);
        Mockito.verify(addressRepository).findById(1L);
        address.addBuildingToAddress(building);
        Mockito.verify(buildingRepository).save(building);
    }

    @Test
    public void testDeleteEntity() {
        String creationDate = "01.01.2020";
        String type = "office";
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building(creationDate, type));
        Mockito.when(buildingRepository.findByCreationDateAndType(creationDate, type)).thenReturn(buildingList);
        buildingService.deleteEntity(creationDate, type);
        Mockito.verify(buildingRepository).findByCreationDateAndType(creationDate, type);
        Mockito.verify(buildingRepository).deleteAll(buildingList);
    }

    @Test
    public void testSortBuildingsOrderedByCreationDate() {
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("01.01.2022", "commercial"));
        buildingList.add(new Building("02.02.2021", "residential"));
        Mockito.when(buildingRepository.findAllSortedByDateAsc()).thenReturn(buildingList);
        List<Building> sortedBuildings = buildingService.sortBuildingsOrderedByCreationDate();
        assertThat(sortedBuildings).containsExactly(buildingList.get(0), buildingList.get(1));
    }

    @Test
    public void testFilterBuildingsByType() {
        String type = "office";
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("01.01.2020", type));
        Mockito.when(buildingRepository.findByType(type)).thenReturn(buildingList);
        List<Building> filteredBuildings = buildingService.filterBuildingsByType(type);
        assertThat(filteredBuildings).isEqualTo(buildingList);
    }

}