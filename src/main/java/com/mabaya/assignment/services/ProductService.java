package com.mabaya.assignment.services;

import com.mabaya.assignment.entities.Campaign;
import com.mabaya.assignment.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final DataBaseService dataBaseService;

    public Product serverAd(String category){

        Product chosenProduct = Product.builder().price(0).build();

        ArrayList<Campaign> filteredCampaigns = dataBaseService.getAllCampaigns().stream()
                .filter(Campaign::isActive)
                .filter(Campaign -> Campaign.getProducts() != null)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Campaign campaign: filteredCampaigns){
            for (Product product: campaign.getProducts()){
                if (product.getCategory().equals(category) && campaign.getBid() > chosenProduct.getPrice()){
                    chosenProduct.setCategory(category);
                    chosenProduct.setPrice(campaign.getBid());
                    chosenProduct.setTitle(product.getTitle());
                    chosenProduct.setSerialNumber(product.getSerialNumber());
                }
            }
        }

        return chosenProduct;

    }


}
