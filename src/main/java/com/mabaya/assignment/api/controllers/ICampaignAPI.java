package com.mabaya.assignment.api.controllers;

import com.mabaya.assignment.api.dto.CreateCampaignDTO;
import com.mabaya.assignment.api.dto.ServerAdDTO;
import com.mabaya.assignment.api.dto.ServerAdRequestParams;
import com.mabaya.assignment.entities.Campaign;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public interface ICampaignAPI {

    @PostMapping("/create/campaign")
    @ResponseStatus(HttpStatus.OK)
    CreateCampaignDTO createCampaign(@RequestBody Campaign campaign);

    @PostMapping("/serve/ad")
    @ResponseStatus(HttpStatus.OK)
    ServerAdDTO serverAd(@RequestBody ServerAdRequestParams serverAdRequestParams);

}
