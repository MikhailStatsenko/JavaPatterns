package com.pw24.pw24.service;

import com.pw24.pw24.model.Address;
import com.pw24.pw24.model.Building;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTest {
    private SchedulerService schedulerService;
    @Mock
    private AddressService addressService;
    @Mock
    private BuildingService buildingService;

    @BeforeEach
    public void setUp() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        schedulerService = new SchedulerService(addressService, buildingService);
    }

    @Test
    public void testMakeBackup() throws Exception {
        SchedulerService schedulerService = Mockito.spy(new SchedulerService(addressService, buildingService));
        Field directoryField = SchedulerService.class.getDeclaredField("DIRECTORY");
        directoryField.setAccessible(true);
        directoryField.set(schedulerService, "src/backups/");

        File backupDirectory = new File("src/backups/");
        FileUtils.deleteDirectory(backupDirectory);
        backupDirectory.mkdirs();

        Address address = new Address();
        Building building = new Building();
        Mockito.when(addressService.getAllAddresses()).thenReturn(Collections.singletonList(address));
        Mockito.when(buildingService.getAllBuildings()).thenReturn(Collections.singletonList(building));

        schedulerService.makeBackup();

        File[] backupFiles = backupDirectory.listFiles();
        assertEquals(2, backupFiles.length);
    }
}