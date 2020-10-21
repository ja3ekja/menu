package com.kitopi.menu.service;

import com.kitopi.menu.domain.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuService {

    private final DishesGroupService dishesGroupService;
    private final ComboService comboService;

    public MenuDTO getMenu() {
        MenuDTO menu = new MenuDTO();
        menu.setDishesGroup(dishesGroupService.getDishesGroup());
        menu.setCombos(comboService.getCombos());
        return menu;
    }
}
