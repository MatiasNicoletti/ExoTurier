package com.exotourier.exotourier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExcursionDto implements Serializable {

    private String name;
    private String description;
    private Float price;
    private String place;
    private String city;
    private String imagePathMain;
    private String imagePathSecondary;
    private String gridClass;

}
