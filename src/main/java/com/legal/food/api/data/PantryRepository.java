package com.legal.food.api.data;

import com.legal.food.api.model.PantryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantryRepository extends JpaRepository<PantryItem, Integer> {
}
