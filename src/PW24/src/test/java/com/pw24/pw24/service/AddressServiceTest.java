package com.pw24.pw24.service;

import com.pw24.pw24.model.Address;
import com.pw24.pw24.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        addressService = new AddressService(addressRepository);
    }

    @Test
    public void testGetAllAddresses() {
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address());
        addressList.add(new Address());
        Mockito.when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> allAddresses = addressService.getAllAddresses();
        assertThat(allAddresses).isEqualTo(addressList);
    }

    @Test
    public void testAddEntity() {
        Address address = new Address();
        addressService.addEntity(address);
        Mockito.verify(addressRepository).save(address);
    }

    @Test
    public void testDeleteEntity() {
        String addressText = "my address";
        int zipCode = 12345;
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(addressText, zipCode));
        Mockito.when(addressRepository.findByAddressTextAndZipCode(addressText, zipCode)).thenReturn(addressList);
        addressService.deleteEntity(addressText, zipCode);
        Mockito.verify(addressRepository).deleteAll(addressList);
    }

    @Test
    public void testSortAddressesOrderedByZipCode() {
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("my address 1", 67890));
        addressList.add(new Address("my address 2", 12345));
        Mockito.when(addressRepository.findAll((Sort) Mockito.any())).thenReturn(addressList);
        List<Address> sortedAddresses = addressService.sortAddressesOrderedByZipCode();
        assertThat(sortedAddresses).containsExactly(addressList.get(0), addressList.get(1));
    }

    @Test
    public void testFilterAddressesByAddressText() {
        String addressText = "my address";
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(addressText, 12345));
        Mockito.when(addressRepository.findByAddressText(addressText)).thenReturn(addressList);
        List<Address> filteredAddresses = addressService.filterAddressesByAddressText(addressText);
        assertThat(filteredAddresses).isEqualTo(addressList);
    }
}