package com.kitopi.menu.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DishDTO {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

}
