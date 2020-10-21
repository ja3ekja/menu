package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.Combo;
import com.kitopi.menu.domain.dto.ComboDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComboMapper {

    private final ModelMapper mapper;

    public Combo mapDtoToDao(ComboDTO dto) {
        return mapper.map(dto, Combo.class);
    }

    public ComboDTO mapDaoToDto(Combo dao) {
        return mapper.map(dao, ComboDTO.class);
    }
}

