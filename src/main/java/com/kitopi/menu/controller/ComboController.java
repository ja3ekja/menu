package com.kitopi.menu.controller;

import com.kitopi.menu.domain.dto.ComboDTO;
import com.kitopi.menu.service.ComboService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/combos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComboController {

    private final ComboService service;

    @GetMapping
    @RequestMapping("/{comboId}")
    public ComboDTO getCombo(@PathVariable Long comboId) {
        log.info("Return combo with id: {} .", comboId);
        return service.getCombo(comboId)
                .getOrElseThrow(() -> {
                    log.warn("Combo with id {} not found", comboId);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish with id " + comboId + " not found");
                });
    }

    @GetMapping
    public List<ComboDTO> getCombos() {
        log.info("Return all combos.");
        return service.getCombos();
    }

    @PostMapping
    public ComboDTO saveCombo(@RequestBody ComboDTO dto) {
        log.info("Add new combo: {}.", dto.getName());
        return service.persistCombo(dto);
    }

    @PatchMapping
    public ComboDTO updateCombo(@RequestBody ComboDTO dto) {
        log.info("Update combo with id: {}.", dto.getId());
        return service.persistCombo(dto);
    }

}
