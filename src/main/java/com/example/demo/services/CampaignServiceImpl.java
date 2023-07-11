package com.example.demo.services;

import java.time.LocalDate;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class CampaignServiceImpl implements CampaignService {

    private static final long ACTIVE_PERIOD_DAYS = 10;
    private final CampaignRepository campaignRepository;
    private final ProductRepository productRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository, ProductRepository productRepository) {
        this.campaignRepository = campaignRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Campaign createCampaign(CampaignDto campaignDto) {
        List<Product> products = productRepository.findAllById(campaignDto.getProductIds());
        Campaign campaign = new Campaign();
        campaign.setName(campaignDto.getName());
        campaign.setStartDate(campaignDto.getStartDate());
        campaign.setBid(campaignDto.getBid());
        campaign.setCategory(campaignDto.getCategory());
        campaign.setProducts(products);
        return campaignRepository.save(campaign);
    }

    @Override
public Product retrieveAd(String category) {
    List<Campaign> campaigns = campaignRepository.findByCategory(category);
    List<Campaign> activeCampaigns = campaigns.stream()
            .filter(this::isActive)
            .collect(Collectors.toList());
    //only for personal propose
    
    System.out.println("Total campaigns: " + campaigns.size());
    System.out.println("Active campaigns: " + activeCampaigns.size());

    if (!activeCampaigns.isEmpty()) {
        Product product = getHighestBidCampaign(activeCampaigns);
        return product;
    }

    // Return null if no active campaign or product found
    return null;
}

private boolean isActive(Campaign campaign) {
    LocalDate startDate = campaign.getStartDate();
    LocalDate endDate = startDate.plusDays(ACTIVE_PERIOD_DAYS);

    return LocalDate.now().isEqual(startDate) || 
           (LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(endDate));
}

    private Product getHighestBidCampaign(List<Campaign> activeCampaigns) {
        Product product = null;
        double highestBid = .0;
        for (Campaign campaign : activeCampaigns) {
            if (campaign.getBid() > highestBid) {
                highestBid = campaign.getBid();
                // get the first product of the campaign
                product = campaign.getProducts().get(0);
            }
        }
        return product;
    }
}
