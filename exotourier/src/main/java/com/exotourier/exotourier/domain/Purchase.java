package com.exotourier.exotourier.domain;

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
    @Basic(optional = false)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "total_price")
    @NotNull
    private float total_price;

}
