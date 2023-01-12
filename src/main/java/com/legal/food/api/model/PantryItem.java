package com.legal.food.api.model;

import com.legal.food.api.pantry.PantryResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pantry_table")
public class PantryItem {
    @Id
    @GeneratedValue
    @Column(name = "pantry_id")
    private Integer id;
    @Column(name = "pantry_name")
    private String name;
    private String barCode;
    private Integer placeDate;
    private Integer expireDate;
    private Float quantity;
    private String unit;
    @ManyToOne(targetEntity = Ingredient.class)
    private Ingredient ingredient;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public static PantryResponse toPantryResponse(PantryItem pantryItem) {
        return PantryResponse.builder()
                .id(pantryItem.getId())
                .barCode(pantryItem.getBarCode())
                .name(pantryItem.getName())
                .placeDate(pantryItem.getPlaceDate())
                .expireDate(pantryItem.getExpireDate())
                .quantity(pantryItem.getQuantity())
                .unit(pantryItem.getUnit())
                .ingredient(pantryItem.getIngredient())
                .build();
    }
}
