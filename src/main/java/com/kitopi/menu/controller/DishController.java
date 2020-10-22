package com.kitopi.menu.controller;

import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishController {

    private final DishService service;

    @GetMapping
    @RequestMapping("/{dishId}")
    public DishDTO getDish(@PathVariable Long dishId) {
        log.info("Return dish information for id: {} .", dishId);
        return service.getDish(dishId).getOrElseThrow(() -> {
            log.warn("Dish with id {} not found", dishId);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish with id " + dishId + " not found");
        });
    }

    @GetMapping
    public List<DishDTO> getDishes() {
        log.info("Return all dishes.");
        return service.getDishes();
    }

    @PostMapping
    public DishDTO saveDish(@RequestBody DishDTO dto) {
        log.info("Add new dish: {}.", dto.getName());
        return service.persistDish(dto);
    }

    @PatchMapping
    public DishDTO updateDish(@RequestBody DishDTO dto) {
        log.info("Update dish with id: {}.", dto.getId());
        return service.persistDish(dto);
    }
}
