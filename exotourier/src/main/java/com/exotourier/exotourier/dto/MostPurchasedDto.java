package com.exotourier.exotourier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MostPurchasedDto {

    private int id_excursion;
    private int numberOfPurchases;
}
