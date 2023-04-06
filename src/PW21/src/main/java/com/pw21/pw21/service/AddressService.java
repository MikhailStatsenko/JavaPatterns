package com.pw21.pw21.service;

import com.pw21.pw21.model.Address;
import com.pw21.pw21.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class AddressService {
    private final AddressRepository addressRepository;
    private final EmailService emailService;
    @Autowired
    public AddressService(AddressRepository addressRepository, EmailService emailService) {
        this.addressRepository = addressRepository;
        this.emailService = emailService;
    }

    public List<Address> getAllAddresses() {
        log.info("Find all addresses");
        return addressRepository.findAll();
    }

    public void addEntity(Address address) {
        log.info("Saving address: {}", address);
        addressRepository.save(address);
    }

    public void deleteEntity(String addressText, int zipCode) {
        log.info("Removing all addresses with addressText = {} and zipCode = {}", addressText, zipCode);
        List<Address> toDelete = addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
        addressRepository.deleteAll(toDelete);
    }

    public List<Address> sortAddressesOrderedByZipCode() {
        log.info("Getting all addresses sorted by zip code");
        return addressRepository.findAll(Sort.by("zipCode"));
    }

    public List<Address> filterAddressesByAddressText(String addressText) {
        log.info("Getting all addresses with addressText = {}", addressText);
        return addressRepository.findByAddressText(addressText);
    }

}
