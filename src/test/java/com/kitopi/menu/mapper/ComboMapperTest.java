package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.Combo;
import com.kitopi.menu.domain.Dish;
import com.kitopi.menu.domain.DishesGroup;
import com.kitopi.menu.domain.dto.ComboDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ComboMapperTest {

    private final ModelMapper modelMapper = new ModelMapper();
    private ComboMapper mapper = new ComboMapper(modelMapper);



    @Test
    public void mapDaoToDtoTest() {
        ComboDTO result = mapper.mapDaoToDto(createCombo());
        String dishName = result.getDishesGroup().get(0).getDishes().get(0).getName();
        assertEquals(dishName, "Burger");
    }

    private Combo createCombo() {
        Combo combo = new Combo();
        combo.setId(5L);
        combo.setName("Combo 1");
        combo.setDishesGroup(createDishesGroups());
        return combo;
    }

    private List<DishesGroup> createDishesGroups() {
        List<DishesGroup> list = new ArrayList<>();
        list.add(createDishesGroups(12L, "Dishes group 1"));
        list.add(createDishesGroups(18L, "Dishes group 2"));
        return list;
    }

    private DishesGroup createDishesGroups(Long id, String name) {
        DishesGroup group = new DishesGroup();
        group.setId(id);
        group.setName(name);
        Dish dish1 = new Dish();
        dish1.setName("Burger");
        List<Dish> dishes = Arrays.asList(dish1);
        group.setDishes(dishes);
        return group;
    }

}