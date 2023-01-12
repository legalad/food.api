package com.legal.food.api.ingredient;

import com.legal.food.api.data.IngredientRepository;
import com.legal.food.api.model.Ingredient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Ingredient getIngredient(Integer id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient not exist with id: " + id));
    }

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }
}
