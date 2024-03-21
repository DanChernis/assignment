package com.mabaya.assignment.services;

import com.google.common.collect.Lists;
import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.entities.DataBase;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
        initialCampaignsForTestingPurposes.add(Campaign.builder().name("campaign1").bid(30).isActive(true).build());
        initialCampaignsForTestingPurposes.add(Campaign.builder().name("campaign2").bid(40).isActive(true).build());
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
