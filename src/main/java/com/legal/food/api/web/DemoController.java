package com.legal.food.api.web;

import com.legal.food.api.data.PantryRepository;
import com.legal.food.api.data.UserRepository;
import com.legal.food.api.model.PantryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class DemoController {
    private final PantryRepository pantryRepository;

    @GetMapping
    public ResponseEntity<String> seyHello() {
        return  ResponseEntity.ok("Hello fron secured endpoint");
    }
    @GetMapping("/test")
    public ResponseEntity<List<PantryItem>> getPantry() {
        return ResponseEntity.ok(pantryRepository.findAll());
    }
}
