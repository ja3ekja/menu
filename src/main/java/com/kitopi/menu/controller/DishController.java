package com.kitopi.menu.controller;

import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return service.getDish(dishId);
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
