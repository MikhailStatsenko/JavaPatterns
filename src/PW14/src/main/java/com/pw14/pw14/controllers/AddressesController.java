package com.pw14.pw14.controllers;

import com.pw14.pw14.Classes.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/addresses")
public class AddressesController {
    private List<Address> addressList = new ArrayList<>();

    @GetMapping("/")
    @ResponseBody
    public List<Address> showAddresses() {
        return addressList;
    }

    @GetMapping("/add")
    public String addAddress(@RequestParam("addressText") String addressText,
                             @RequestParam("zipCode") String zipCode) {
        addressList.add(new Address(addressText, zipCode));
        return "redirect:/addresses/";
    }

    @GetMapping("/delete")
    public String deleteAddress(@RequestParam("addressText") String addressText,
                                @RequestParam("zipCode") String zipCode) {
        for (Address address : addressList) {
            if (address.getAddressText().equals(addressText) && address.getZipCode().equals(zipCode)) {
                addressList.remove(address);
                return "redirect:/addresses/";
            }
        }
        return "redirect:/addresses/";
    }

}
