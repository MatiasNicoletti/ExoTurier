package com.exotourier.exotourier.domain;

<<<<<<< HEAD
=======

import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

@Entity
@Table(name = "excursions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
<<<<<<< HEAD

=======
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
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
=======
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Float price;

    @NotNull
    private String place;

    @NotNull
    private boolean isActive;

    @NotNull
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "purchase")
    private List<Purchase> purchases;

    // verificar
    @JsonBackReference
    @ManyToMany(mappedBy = "user")
    private List<User> users = new ArrayList<>();
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

}
