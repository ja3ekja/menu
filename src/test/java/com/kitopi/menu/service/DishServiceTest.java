package com.kitopi.menu.service;

import com.kitopi.menu.domain.Dish;
import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.mapper.DishMapper;
import com.kitopi.menu.repository.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DishServiceTest {

    private DishRepository repository;
    private DishService service;
    private DishMapper dishMapper;
    private ModelMapper modelMapper;


    @BeforeEach
    public void init() {
        repository = mock(DishRepository.class);
        modelMapper = new ModelMapper();
        dishMapper = new DishMapper(modelMapper);
        service = new DishService(dishMapper, repository);
    }

    @Test
    @DisplayName("This is test to verify getting dish from mocked DB")
    public void getDishTest() {
        //Given
        DishDTO mockedDish = createDTO();
        //When
        when(repository.findById(5L)).thenReturn(createOptionalDAO());
//        when().thenReturn();
        //Then
        DishDTO dish = service.getDish(5L);
        assertEquals(dish, mockedDish);
    }

    private DishDTO createDTO() {
        DishDTO dto = new DishDTO();
        dto.setId(5L);
        dto.setName("Cheese burger");
        return dto;
    }

    private Optional<Dish> createOptionalDAO() {
        Dish dto = new Dish();
        dto.setId(5L);
        dto.setName("Cheese burger");
        return Optional.of(dto);
    }

}