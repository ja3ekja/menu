package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.Dish;
import com.kitopi.menu.domain.dto.DishDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishMapper {

    private final ModelMapper mapper;

    public Dish mapDtoToDao(DishDTO dto) {
        return mapper.map(dto, Dish.class);
    }

    public DishDTO mapDaoToDto(Dish dao) {
        return mapper.map(dao, DishDTO.class);
    }
}
