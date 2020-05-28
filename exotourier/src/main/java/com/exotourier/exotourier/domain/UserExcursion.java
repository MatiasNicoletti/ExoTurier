package com.exotourier.exotourier.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_x_excursions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserExcursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=false, nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonBackReference(value = "userExcursionUser")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_excursion")
    @JsonBackReference(value = "userExcursionExcursion")
    private Excursion excursion;

    @Column(name = "rating")
    @NotNull
    private Float rating;

}
