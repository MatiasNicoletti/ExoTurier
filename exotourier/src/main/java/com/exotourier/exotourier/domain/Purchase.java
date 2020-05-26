package com.exotourier.exotourier.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "purchase_date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "total_price")
    @NotNull
    private float totalPrice;

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
