package com.mabaya.assignment.services;

import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.entities.DataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CampaignService{

    private final DataBaseService dataBaseService;

    public boolean createCampaign(Campaign campaign){
        dataBaseService.addCampaign(campaign);
        return true;
    }
}
