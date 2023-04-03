package com.pw15.pw15.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "buildings")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Building {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "creationdate")
    private String creationDate;
    @Column(name = "type")
    private String type;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }
}
