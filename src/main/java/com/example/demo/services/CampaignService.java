package com.example.demo.services;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.CampaignDto;

public interface CampaignService {
    Campaign createCampaign(CampaignDto campaignDto);
    Product retrieveAd(String category);
}
