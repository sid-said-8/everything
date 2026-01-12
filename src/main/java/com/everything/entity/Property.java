package com.everything.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "no_of_rooms", nullable = false)
    private String no_of_rooms;

    @Column(name = "no_of_beds", nullable = false)
    private String no_of_beds;

    @Column(name = "no_of_bathroom", nullable = false)
    private String no_of_bathroom;

    @Column(name = "no_of_guest", nullable = false)
    private String no_of_guest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

}