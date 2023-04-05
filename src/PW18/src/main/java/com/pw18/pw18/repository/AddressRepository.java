package com.pw18.pw18.repository;

import com.pw18.pw18.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByAddressTextAndZipCode(String addressText, int zipCode);
    List<Address> findByAddressText(String addressText);

}
