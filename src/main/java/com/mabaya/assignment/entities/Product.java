package com.mabaya.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class Product {

    private String title;
    private String category;
    private Integer price;
    private String serialNumber;

}
