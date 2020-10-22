package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.Dish;
import com.kitopi.menu.domain.dto.DishDTO;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DishMapperTest {


    private static EnhancedRandom randomGenerator;
    private static ModelMapper modelMapper;
    private static DishMapper mapper;

    @BeforeAll
    public static void setup() {
        randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        modelMapper = new ModelMapper();
        mapper = new DishMapper(modelMapper);
    }

    @Test
    public void mapDaoToDtoTest() {
        //Given
        Dish mockedDao = randomGenerator.nextObject(Dish.class);

        //Then
        DishDTO dtoResult = mapper.mapDaoToDto(mockedDao);
        assertThat(dtoResult.getPrice(), is(mockedDao.getPrice()));
        assertThat(dtoResult.getName(), is(mockedDao.getName()));
    }

    @Test
    public void mapDtoToDaoTest() {
        //Given
        DishDTO mockedDto = randomGenerator.nextObject(DishDTO.class);

        //Then
        Dish daoResult = mapper.mapDtoToDao(mockedDto);
        assertThat(daoResult.getPrice(), is(mockedDto.getPrice()));
        assertThat(daoResult.getName(), is(mockedDto.getName()));
    }

}