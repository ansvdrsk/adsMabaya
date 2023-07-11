package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.services.CampaignService;

@RestController
@RequestMapping("/")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping("/create-campaign")
    public ResponseEntity<Campaign> createCampaign(@RequestBody CampaignDto campaignDto) {
        Campaign campaign = campaignService.createCampaign(campaignDto);
        return new ResponseEntity<>(campaign, HttpStatus.CREATED);
    }

    @GetMapping("/serve-ad")
    public ResponseEntity<Product> serveAd(@RequestParam("category") String category) {
        Product product = campaignService.retrieveAd(category);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
