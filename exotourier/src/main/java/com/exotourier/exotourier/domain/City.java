package com.exotourier.exotourier.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=false, nullable = false)
    private Integer id;

    @Column(name = "city_name")
    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country")
    private Country country;

    @NotNull
    @OneToMany(mappedBy = "city")
    private List<Excursion> excursions;

}
