package com.legal.food.api.pantry;

import com.legal.food.api.data.IngredientRepository;
import com.legal.food.api.data.PantryRepository;
import com.legal.food.api.data.UserRepository;
import com.legal.food.api.model.PantryItem;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PantryService {

    private final PantryRepository pantryRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;




    public List<PantryResponse> getPantry() {
        List<PantryResponse> pantryResponseList = new ArrayList<>();
        pantryRepository.findAll().forEach(i ->
                pantryResponseList.add(
                        PantryItem.toPantryResponse(i)
                )
                );
        return pantryResponseList;
    }

    public PantryResponse getPantryItem(Integer id) {
        PantryItem pantryItem = pantryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pantry item not exist with id: " + id));
        return PantryItem.toPantryResponse(pantryItem);
    }

    public PantryResponse addPantryItem(PantryItemRequest request) {
        return getPantryItem(pantryRepository.save(
                PantryItem.builder()
                        .barCode(request.getBarCode())
                        .name(request.getName())
                        .placeDate(request.getPlaceDate())
                        .expireDate(request.getExpireDate())
                        .quantity(request.getQuantity())
                        .unit(request.getUnit())
                        .user(userRepository.findById(request.getUserId())
                                .orElseThrow(() -> new EntityNotFoundException("User not exist with id: " + request.getUserId())))
                        .ingredient(ingredientRepository.findById(request.getIngredientId())
                                .orElseThrow(() -> new EntityNotFoundException("Ingredient not exist with id: " + request.getIngredientId())))
                        .build()
        ).getId());
    }

    public List<PantryResponse> addPantryItemList(List<PantryItemRequest> requestList) {
        List<PantryResponse> pantryResponseList = new ArrayList<PantryResponse>();
        requestList.forEach( item -> pantryResponseList.add(addPantryItem(item)) );
        return pantryResponseList;
    }

    public PantryResponse updatePantryItem(Integer id, PantryItemRequest request) {
        PantryItem pantryItem = pantryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pantry item not exist with id: " + id));
        pantryItem.setBarCode(request.getBarCode());
        pantryItem.setName(request.getName());
        pantryItem.setPlaceDate(request.getPlaceDate());
        pantryItem.setExpireDate(request.getExpireDate());
        pantryItem.setQuantity(request.getQuantity());
        pantryItem.setUnit(request.getUnit());

        return getPantryItem(pantryRepository.save(pantryItem).getId());
    }

    public void deletePantryItem(Integer id) {
        pantryRepository.deleteById(id);
    }
}
