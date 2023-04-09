package com.pw23.pw23.service;

import com.pw23.pw23.model.Address;
import com.pw23.pw23.model.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.management.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource
public class SchedulerService {
    private final String DIRECTORY = "src/backups/";
    private final AddressService addressService;
    private final BuildingService buildingService;
    @Autowired
    public SchedulerService(AddressService addressService, BuildingService buildingService) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        this.addressService = addressService;
        this.buildingService = buildingService;
    }

    @ManagedOperation
//    @Scheduled(cron = "*/20 * * * * *")
    @Scheduled(cron = "0 */30 * * * *")
    public void makeBackup() throws IOException {
        log.info("Scheduled task started: deleting files");
        File backupDir = ResourceUtils.getFile(DIRECTORY);
        for (File file : backupDir.listFiles()) {
            if (file.isFile()) {
                file.delete();
                log.info("File {} deleted", file.getName());
            }
        }
        log.info("All files deleted\n" +
                "Writing updated data from addresses and buildings tables");

        FileWriter writer = new FileWriter(DIRECTORY + "addresses.txt");
        for (Address address : addressService.getAllAddresses()) {
            writer.write(address.toString() + '\n');
        }
        writer.close();

        writer = new FileWriter(DIRECTORY + "buildings.txt");
        for (Building building : buildingService.getAllBuildings()) {
            writer.write(building.toString() + '\n');
        }
        writer.close();
        log.info("Finished writing\n" +
                "Scheduled task ended");
    }
}
