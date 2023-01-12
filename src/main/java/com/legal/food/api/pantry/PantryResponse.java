package com.legal.food.api.pantry;

import com.legal.food.api.model.Ingredient;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PantryResponse {
    private Integer id;
    private String name;
    private String barCode;
    private Integer placeDate;
    private Integer expireDate;
    private Float quantity;
    private String unit;
    private Ingredient ingredient;
}
