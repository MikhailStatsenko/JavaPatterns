package com.pw18.pw18.service;

import com.pw18.pw18.model.Address;
import com.pw18.pw18.model.Building;
import com.pw18.pw18.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addEntity(Address address) {
        addressRepository.save(address);
    }

    public void deleteEntity(String addressText, int zipCode) {
        List<Address> toDelete = addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
        addressRepository.deleteAll(toDelete);
    }

    public List<Address> sortAddressesOrderedByZipCode() {
        return addressRepository.findAll(Sort.by("zipCode"));
    }

    public List<Address> filterAddressesByAddressText(String addressText) {
        return addressRepository.findByAddressText(addressText);
    }

}
