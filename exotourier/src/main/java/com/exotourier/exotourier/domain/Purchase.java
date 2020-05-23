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
import java.time.LocalDateTime;
=======
import java.util.Date;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

@Entity
@Table(name = "purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Basic(optional = false)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "total_price")
    @NotNull
    private float total_price;
=======
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
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

}
