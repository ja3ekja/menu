package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.DishesGroup;
import com.kitopi.menu.domain.dto.DishesGroupDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishesGroupMapper {

    private final ModelMapper mapper;

    public DishesGroupDTO mapDaoToDto(DishesGroup dao) {
        return mapper.map(dao, DishesGroupDTO.class);
    }
}
