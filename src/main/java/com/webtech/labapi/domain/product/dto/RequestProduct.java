package com.webtech.labapi.domain.product.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO
//objeto somente para transferencia de dados (DTO -data transfer object)
public record RequestProduct(
        String id,
        @NotBlank String name,
        @NotNull float price) {
}
