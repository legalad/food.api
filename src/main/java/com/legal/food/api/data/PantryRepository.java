package com.legal.food.api.data;

import com.legal.food.api.model.PantryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PantryRepository extends JpaRepository<PantryItem, Integer> {

}
