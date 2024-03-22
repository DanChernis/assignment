package com.mabaya.assignment.api;

import com.mabaya.assignment.api.controllers.ICampaignAPI;
import com.mabaya.assignment.api.dto.CreateCampaignDTO;
import com.mabaya.assignment.api.dto.ServerAdDTO;
import com.mabaya.assignment.api.dto.ServerAdRequestParams;
import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.services.CampaignService;
import com.mabaya.assignment.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequiredArgsConstructor
public class CampaignAPI implements ICampaignAPI {

    private final CampaignService campaignService;
    private final ProductService productService;

    @Override
    public @ResponseBody CreateCampaignDTO createCampaign(@RequestBody Campaign campaign) {
        return CreateCampaignDTO.builder()
                .created(campaignService.createCampaign(campaign))
                .build();
    }

    @Override
    public @ResponseBody ServerAdDTO serverAd(@RequestBody ServerAdRequestParams serverAdRequestParams) {
        return ServerAdDTO.builder()
                .product(productService.serverAd(serverAdRequestParams.getCategory()))
                .build();
    }
}
