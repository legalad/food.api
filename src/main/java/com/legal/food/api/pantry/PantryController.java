package com.legal.food.api.pantry;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/pantry")
public class PantryController {

    private final PantryService service;


    //Get
    @GetMapping("/items")
    public ResponseEntity<List<PantryResponse>> getPantry(){
        try {
            return ResponseEntity.ok(service.getPantry());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().header(e.getMessage()).build();
        }
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<PantryResponse> getPantryItem(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPantryItem(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().header(e.getMessage()).build();
        }
    }

    //Post
    @PostMapping("/item")
    public ResponseEntity<PantryResponse> addPantryItem(
            @RequestBody PantryItemRequest request
    ) {
        try {
            return ResponseEntity.ok(service.addPantryItem(request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/items")
    public ResponseEntity<List<PantryResponse>> addPantryItemsList(
            @RequestBody List<PantryItemRequest> requestList
    ) {

        try {
            return ResponseEntity.ok(service.addPantryItemList(requestList));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Put
    @PutMapping("/item/{id}")
    public ResponseEntity<PantryResponse> updatePantryItem(
            @PathVariable Integer id,
            @RequestBody PantryItemRequest request
    ) {
        try {
           return ResponseEntity.ok(service.updatePantryItem(id, request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete
    @DeleteMapping("/item/{id}")
    public ResponseEntity<PantryResponse> deletePantryItem(
            @PathVariable Integer id
    ) {
        try {
            return ResponseEntity.ok(service.deletePantryItem(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
