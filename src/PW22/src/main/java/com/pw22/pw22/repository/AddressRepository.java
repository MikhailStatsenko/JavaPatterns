package com.pw22.pw22.repository;

import com.pw22.pw22.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByAddressTextAndZipCode(String addressText, int zipCode);
    List<Address> findByAddressText(String addressText);

}
