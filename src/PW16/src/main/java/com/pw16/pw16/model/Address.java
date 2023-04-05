package com.pw16.pw16.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "addresstext")
    private String addressText;
    @Column(name = "zipcode")
    private String zipCode;
    // Lazy по умолчанию
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH},
            mappedBy = "address",
            fetch = FetchType.LAZY)
    private List<Building> buildings;
    public Address(String addressText, String zipCode) {
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
