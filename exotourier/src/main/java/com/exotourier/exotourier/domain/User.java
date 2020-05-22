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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "is_active")
    @NotNull
    private Boolean isActive;

    @OneToMany(mappedBy = "purchase")
    private List<Purchase> purchases;

    //verificar
    @ManyToMany()
    @JoinTable(
            name = "users_x_excursions",
            joinColumns = @JoinColumn(name = "id_user") ,
            inverseJoinColumns = @JoinColumn(name = "id_excursion")
    )
    private List<Excursion> users = new ArrayList<>();

}
