package com.mabaya.assignment.services;

import com.google.common.collect.Lists;
import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.entities.DataBase;
import com.mabaya.assignment.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataBaseService {

    private DataBase dataBase;
    @Autowired
    public DataBaseService(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @PostConstruct
    public void onInit(){
        ArrayList<Campaign> initialCampaignsForTestingPurposes = Lists.newArrayList();
        Product product1 = Product.builder().price(4).title("product1").serialNumber("0001").category("clothes").build();
        Product product2 = Product.builder().price(7).title("product2").serialNumber("0002").category("clothes").build();
        Product product3 = Product.builder().price(11).title("product3").serialNumber("0003").category("clothes").build();
        initialCampaignsForTestingPurposes.add(
            Campaign.builder()
            .name("campaign1")
            .bid(30)
            .products(Lists.newArrayList(product1))
            .isActive(true)
            .build()
        );
        initialCampaignsForTestingPurposes.add(
            Campaign.builder()
            .name("campaign2")
            .bid(40)
            .isActive(true)
                    .products(Lists.newArrayList(product2, product3))
            .build()
        );
        dataBase.setDb(initialCampaignsForTestingPurposes);
    }

    public void addCampaign(Campaign campaign){
        ArrayList<Campaign> currentCampaigns = dataBase.getDb();
        currentCampaigns.add(campaign);
        dataBase.setDb(currentCampaigns);
    }

    public ArrayList<Campaign> getAllCampaigns(){
        return dataBase.getDb();
    }
}
