package com.mabaya.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
@AllArgsConstructor
@Data
@Builder
public class Campaign {
    private String name;
    private ArrayList<Product> products;
    private Date startDate;
    private int bid;
    private boolean isActive;
}
