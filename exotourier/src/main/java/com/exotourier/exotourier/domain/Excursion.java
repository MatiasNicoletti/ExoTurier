package com.exotourier.exotourier.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "excursions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Excursion {

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
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = false)
    private City city;


    /* verificar
    @JsonBackReference
    @ManyToMany(mappedBy = "user")
    private List<User> users;
*/
    @OneToMany(mappedBy = "excursion")
    @JsonBackReference
    private List<UserExcursion> userExcursionList;

    @OneToMany(mappedBy = "excursion")
    @JsonBackReference
    private List<Purchase> purchaseList;

}
