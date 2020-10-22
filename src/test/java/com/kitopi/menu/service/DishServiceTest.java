package com.kitopi.menu.service;

import com.kitopi.menu.domain.Dish;
import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.mapper.DishMapper;
import com.kitopi.menu.repository.DishRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DishServiceTest {

    private static DishRepository repository;
    private static DishService service;


    @BeforeAll
    public static void init() {
        repository = mock(DishRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        DishMapper dishMapper = new DishMapper(modelMapper);
        service = new DishService(dishMapper, repository);
    }

    @Test
    @DisplayName("This is test to verify getting dish from mocked DB")
    public void getDishTest() {
        //Given
        EnhancedRandom randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        Dish mockedDish = randomGenerator.nextObject(Dish.class);
        Long mockedDishId = mockedDish.getId();

        //When
        when(repository.findById(mockedDishId)).thenReturn(Optional.of(mockedDish));

        DishDTO dish = service.getDish(mockedDishId).get();

        //Then
        assertEquals(dish.getId(), mockedDish.getId());
        assertEquals(dish.getName(), mockedDish.getName());
        assertEquals(dish.getDescription(), mockedDish.getDescription());
        assertEquals(dish.getPrice(), mockedDish.getPrice());
    }


    @Test
    @DisplayName("This is test to verify return empty Optional from dB")
    public void getNonExistingDishTest() {
        //When
        when(repository.findById(any())).thenReturn(Optional.empty());
        Option<DishDTO> dish = service.getDish(1L);

        //Then
        assertTrue(dish.isEmpty());
    }
}