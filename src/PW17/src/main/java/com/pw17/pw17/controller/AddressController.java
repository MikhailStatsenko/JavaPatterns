package com.pw17.pw17.controller;

import com.pw17.pw17.model.Address;
import com.pw17.pw17.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Address> showAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/add")
    public String addAddress(@RequestParam String addressText,
                             @RequestParam int zipCode) {
        addressService.addEntity(new Address(addressText, zipCode));
        return "redirect:/addresses/";
    }


    @GetMapping("/delete")
    public String deleteAddress(@RequestParam("addressText") String addressText,
                                @RequestParam("zipCode") int zipCode) {
        addressService.deleteEntity(new Address(addressText, zipCode));
        return "redirect:/addresses/";
    }

    @GetMapping("/sorted_by_zip_code")
    @ResponseBody
    public String showAddressesOrderedByZipCode() {
        return addressService.sortAddressesOrderedByZipCode().toString();
    }

    @GetMapping("/{addressText}")
    @ResponseBody
    public String showAddressesByAddressText(@PathVariable String addressText) {
        return  addressService.filterAddressesByAddressText(addressText).toString();
    }

}

