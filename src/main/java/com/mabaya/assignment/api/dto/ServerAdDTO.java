package com.mabaya.assignment.api.dto;

import com.mabaya.assignment.entities.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServerAdDTO {

    private Product product;

}
