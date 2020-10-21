package com.kitopi.menu.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class DishesGroupDTO {

    private Long id;

    @NotNull
    private String name;

    private String description;

    private List<DishDTO> dishes;
}
