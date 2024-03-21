package com.mabaya.assignment.api;

import com.mabaya.assignment.api.controllers.ICampaignAPI;
import com.mabaya.assignment.api.dto.CreateCampaignDTO;
import com.mabaya.assignment.api.dto.ServerAdDTO;
import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.services.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequiredArgsConstructor
public class CampaignAPI implements ICampaignAPI {
    private final CampaignService campaignService;
    @Override
    public @ResponseBody CreateCampaignDTO createCampaign(@RequestBody Campaign campaign) {
        return CreateCampaignDTO.builder()
                .created(campaignService.createCampaign(campaign))
                .build();
    }

    @Override
    public @ResponseBody ServerAdDTO serverAd(@RequestBody Campaign campaign) {
        return null;
    }
}
