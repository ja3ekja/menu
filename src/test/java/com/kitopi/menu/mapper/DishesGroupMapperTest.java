package com.kitopi.menu.mapper;

import com.kitopi.menu.domain.DishesGroup;
import com.kitopi.menu.domain.dto.DishesGroupDTO;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DishesGroupMapperTest {

    private static EnhancedRandom randomGenerator;
    private static ModelMapper modelMapper;
    private static DishesGroupMapper mapper;

    @BeforeAll
    public static void setup() {
        randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        modelMapper = new ModelMapper();
        mapper = new DishesGroupMapper(modelMapper);
    }

    @Test
    public void mapDaoToDtoTest() {
        //Given
        DishesGroup mockedDao = randomGenerator.nextObject(DishesGroup.class);

        //Then
        DishesGroupDTO dtoResult = mapper.mapDaoToDto(mockedDao);
        assertThat(dtoResult.getName(), is(mockedDao.getName()));
        assertThat(dtoResult.getDishes().get(0).getId(), is(mockedDao.getDishes().get(0).getId()));
    }
}