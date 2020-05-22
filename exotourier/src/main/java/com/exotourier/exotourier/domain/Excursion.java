package com.exotourier.exotourier.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "excursions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "price")
    @NotNull
    private float price;

    @Column(name = "place")
    @NotNull
    private String place;

    @Column(name = "is_active")
    @NotNull
    private boolean is_active;

}
