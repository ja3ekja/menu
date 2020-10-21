package com.kitopi.menu.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {

    private List<DishesGroupDTO> dishesGroup;
    private List<ComboDTO> combos;

}
