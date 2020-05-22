package com.exotourier.exotourier.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Date date;

    @NotNull
    private Float totalPrice;

    @NotNull
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_excursion", nullable = false)
    private Excursion excursion;

    @NotNull
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
