package com.pw18.pw18.repository;

import com.pw18.pw18.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findByCreationDateAndType(String creationDate, String type);
    List<Building> findByType(String type);
    @Query("SELECT b FROM Building b ORDER BY TO_DATE(b.creationDate, 'dd.mm.yyyy') ASC")
    List<Building> findAllSortedByDateAsc();
}
