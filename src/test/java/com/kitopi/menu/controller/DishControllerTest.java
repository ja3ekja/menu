package com.kitopi.menu.controller;

import com.kitopi.menu.service.DishService;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DishControllerTest {

    private static DishService service;
    private static DishController controller;


    @BeforeAll
    public static void init() {
        service = mock(DishService.class);
        controller = new DishController(service);
    }

    @Test
    @DisplayName("This is test to verify return empty Optional from dB")
    void getNonExistingDishTest() {
        //When
        when(service.getDish(any())).thenReturn(Option.none());

        //Then
        assertThrows(ResponseStatusException.class, () -> controller.getDish(5L));
    }
}