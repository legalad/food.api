package com.legal.food.api.model;

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
    @Column(name = "user_id")
    private Integer userId;

}
