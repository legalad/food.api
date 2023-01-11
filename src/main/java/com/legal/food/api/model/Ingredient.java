package com.legal.food.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient_table")
public class Ingredient {
    @Id
    @GeneratedValue
    @Column(name = "ingredient_id")
    private Integer id;
    @Column(name = "ingredient_name")
    private String name;
    @Column(name = "scientific_name")
    private String scientificName;
    @Column(name = "ingredient_group")
    private String group;
    @Column(name = "ingredient_sub_group")
    private String subGroup;

}
