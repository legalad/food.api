package com.legal.food.api.pantry;

import com.legal.food.api.model.PantryItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PantryItemRequest {
    private String name;
    private String barCode;
    private Long placeDate;
    private Long expireDate;
    private Float quantity;
    private String unit;
    private Integer ingredientId;
    private Integer userId;

}
