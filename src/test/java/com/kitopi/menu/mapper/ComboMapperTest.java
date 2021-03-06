package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.Combo;
import com.kitopi.menu.domain.dto.ComboDTO;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class ComboMapperTest {

    private static EnhancedRandom randomGenerator;
    private static ModelMapper modelMapper;
    private static ComboMapper mapper;

    @BeforeAll
    public static void setup() {
        randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        modelMapper = new ModelMapper();
        mapper = new ComboMapper(modelMapper);
    }

    @Test
    public void mapDaoToDtoTest() {
        //Given
        Combo mockedDao = randomGenerator.nextObject(Combo.class);

        //Then
        ComboDTO dtoResult = mapper.mapDaoToDto(mockedDao);
        assertThat(dtoResult.getDishesGroup().get(0).getDishes().get(0).getPrice(),
                is(mockedDao.getDishesGroup().get(0).getDishes().get(0).getPrice()));
    }

    @Test
    public void mapDtoToDaoTest() {
        //Given
        ComboDTO mockedDto = randomGenerator.nextObject(ComboDTO.class);

        //Then
        Combo daoResult = mapper.mapDtoToDao(mockedDto);
        assertThat(daoResult.getDishesGroup().get(0).getDescription(),
                is(mockedDto.getDishesGroup().get(0).getDescription()));
    }
}