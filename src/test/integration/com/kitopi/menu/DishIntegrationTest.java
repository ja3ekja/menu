package com.kitopi.menu;

import com.kitopi.menu.domain.dto.ComboDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = MenuApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DishIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void updateComboTest() {
        //Given
        URI uri = URI.create("http://localhost:" + port + "/combos");
        ComboDTO combo = restTemplate.getForObject(uri + "/2", ComboDTO.class);
        String oldDescription = combo.getDescription();
        String newDescription = "New Description";

        //When
        combo.setDescription(newDescription);
        restTemplate.postForObject(uri, new HttpEntity(combo), ComboDTO.class);
        ComboDTO updatedCombo = restTemplate.getForObject(uri + "/2", ComboDTO.class);

        //Then
        assertFalse(updatedCombo.getDescription().equals(oldDescription));
        assertThat(updatedCombo.getDescription(), is(newDescription));
    }
}
