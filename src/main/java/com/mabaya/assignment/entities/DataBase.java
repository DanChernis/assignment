package com.mabaya.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@AllArgsConstructor
@Data
@Repository
public class DataBase {
    private ArrayList<Campaign> db;
}
