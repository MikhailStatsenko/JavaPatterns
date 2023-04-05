package com.pw16.pw16.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "buildings")
@Setter
@Getter
@NoArgsConstructor
public class Building {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "creationdate")
    private String creationDate;
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
