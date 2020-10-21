package com.kitopi.menu.controller;

import com.kitopi.menu.domain.dto.MenuDTO;
import com.kitopi.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuController {

    private final MenuService service;

    @GetMapping
    public MenuDTO getMenu() {
        log.info("Return whole menu.");
        return service.getMenu();
    }
}
