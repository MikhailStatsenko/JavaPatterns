package com.pw15.pw15.controller;

import com.pw15.pw15.model.Address;
import com.pw15.pw15.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
                             @RequestParam String zipCode) {
        addressService.addEntity(new Address(addressText, zipCode));
        return "redirect:/addresses/";
    }


    @GetMapping("/delete")
    public String deleteAddress(@RequestParam("addressText") String addressText,
                                @RequestParam("zipCode") String zipCode) {
        addressService.deleteEntity(new Address(addressText, zipCode));
        return "redirect:/addresses/";
    }

}

