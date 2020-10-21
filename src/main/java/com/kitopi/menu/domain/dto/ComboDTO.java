package com.kitopi.menu.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ComboDTO {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    private List<DishesGroupDTO> dishesGroup;
}
