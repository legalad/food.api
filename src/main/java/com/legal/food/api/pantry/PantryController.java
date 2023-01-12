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
    public ResponseEntity<String> addPantryItem(
            @RequestBody PantryItemRequest request
    ) {
        try {
            service.addPantryItem(request);
            return ResponseEntity.ok("Pantry item added.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/items")
    public ResponseEntity<String> addPantryItemsList(
            @RequestBody List<PantryItemRequest> requestList
    ) {

        try {
            service.addPantryItemList(requestList);
            return ResponseEntity.ok("Pantry item list added.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Put
    @PutMapping("/item/{id}")
    public ResponseEntity<String> updatePantryItem(
            @PathVariable Integer id,
            @RequestBody PantryItemRequest request
    ) {
        try {
            service.updatePantryItem(id, request);
            return ResponseEntity.ok("Pantry item updated.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Delete
    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deletePantryItem(
            @PathVariable Integer id
    ) {
        service.deletePantryItem(id);
        return ResponseEntity.ok("Pantry item deleted.");
    }

}
