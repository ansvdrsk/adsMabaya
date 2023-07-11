package com.example.demo.entities.dto;

import java.time.LocalDate;
import java.util.List;

public class CampaignDto {

    private String name;
    private LocalDate startDate;
    private List<Long> productIds;
    private double bid;
    private String category;

    public CampaignDto() {
    }

    public CampaignDto(String name, LocalDate startDate, List<Long> productIds, double bid, String category) {
        this.name = name;
        this.startDate = startDate;
        this.productIds = productIds;
        this.bid = bid;
        this.category = category;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
