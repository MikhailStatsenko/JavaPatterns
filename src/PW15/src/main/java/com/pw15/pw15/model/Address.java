package com.pw15.pw15.model;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "addresses")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "addresstext")
    private String addressText;
    @Column(name = "zipcode")
    private String zipCode;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }
}
