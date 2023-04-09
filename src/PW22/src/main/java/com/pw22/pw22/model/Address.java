package com.pw22.pw22.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Setter
@Getter
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "address_text")
    private String addressText;
    @Column(name = "zip_code")
    private int zipCode;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH},
            mappedBy = "address")
    @JsonIgnore
    private List<Building> buildings;

    public Address(String addressText, int zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    public void addBuildingToAddress(Building building) {
        if (buildings == null)
            buildings = new ArrayList<>();
        buildings.add(building);
        building.setAddress(this);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressText='" + addressText + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
