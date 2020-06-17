package com.exotourier.exotourier.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "excursions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class    Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "excursion_name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Float price;

    @NotNull
    @Column(name = "place")
    private String place;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @Column(name = "grid_class")
    private String gridClass;

    @NotNull
    @Column(name = "image_path_main")
    private String  image_path_main;

    @NotNull
    @Column(name = "image_path_main")
    private String  image_path_secondary;

    @NotNull
    @JsonBackReference(value = "excursionCity")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "excursion")
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "excursion")
    private List<UserExcursion> userExcursionList;


}
