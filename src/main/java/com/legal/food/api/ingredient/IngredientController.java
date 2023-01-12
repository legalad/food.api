package com.legal.food.api.ingredient;

import com.legal.food.api.model.Ingredient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/data")
public class IngredientController {

    private final IngredientService service;

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getIngredient(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().header(e.getMessage()).build();
        }
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients() {
        try {
            return ResponseEntity.ok(service.getIngredients());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().header(e.getMessage()).build();
        }
    }
}
