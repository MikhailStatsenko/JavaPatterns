package com.pw19.pw19.repository;

import com.pw19.pw19.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByAddressTextAndZipCode(String addressText, int zipCode);
    List<Address> findByAddressText(String addressText);

}
