package com.kitopi.menu;

import com.kitopi.menu.domain.dto.ComboDTO;
import com.kitopi.menu.domain.dto.DishesGroupDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MenuApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuFunctionalTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("This integration test is to verify update and test whole business flow.")
    public void updateComboTest() {
        //Given
        URI uri = URI.create("http://localhost:" + port + "/combos");
        ComboDTO combo = restTemplate.getForObject(uri + "/1", ComboDTO.class);
        String oldDescription = combo.getDescription();
        String newDescription = "New Description";

        //When
        combo.setDescription(newDescription);
        restTemplate.postForObject(uri, new HttpEntity(combo), ComboDTO.class);
        ComboDTO updatedCombo = restTemplate.getForObject(uri + "/1", ComboDTO.class);

        //Then
        assertNotEquals(updatedCombo.getDescription(), oldDescription);
        assertThat(updatedCombo.getDescription(), is(newDescription));
    }

    @Test
    @DisplayName("This integration test is to verify update and test whole business flow.")
    public void updateComboWithGroupTest() {
        //Given
        URI uri = URI.create("http://localhost:" + port + "/combos");
        ComboDTO combo = restTemplate.getForObject(uri + "/2", ComboDTO.class);
        DishesGroupDTO beverageDishesGroup = restTemplate.getForObject(uri + "/1", ComboDTO.class)
                .getDishesGroup()
                .stream()
                .filter(item -> item.getId().equals(2L))
                .findFirst().get();


        //When
        combo.getDishesGroup().remove(1);
        combo.getDishesGroup().add(beverageDishesGroup);
        restTemplate.postForObject(uri, new HttpEntity(combo), ComboDTO.class);
        ComboDTO updatedCombo = restTemplate.getForObject(uri + "/2", ComboDTO.class);

        //Then
        assertThat(updatedCombo.getDishesGroup().size(), is(2));
        assertTrue(updatedCombo.getDishesGroup().contains(beverageDishesGroup));
    }

    @Test
    @DisplayName("Verify get non existing dish.")
    public void getNonExistingDishTest() {
        //Given
        URI uri = URI.create("http://localhost:" + port + "/dish");

        //When
        ResponseEntity<ComboDTO> result = restTemplate.getForEntity(uri + "/99", ComboDTO.class);

        //Then
        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
