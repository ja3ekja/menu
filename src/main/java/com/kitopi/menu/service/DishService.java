package com.kitopi.menu.service;

import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.mapper.DishMapper;
import com.kitopi.menu.repository.DishRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishService {

    private final DishMapper mapper;
    private final DishRepository repository;

    public DishDTO getDish(Long dishId) {
        return Option.ofOptional(repository.findById(dishId))
                .map(mapper::mapDaoToDto)
                .getOrElseThrow(() -> {
                    log.warn("Dish with id {} not found", dishId);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish with id " + dishId + " not found");
                });
    }

    public List<DishDTO> getDishes() {
        return repository.findAll().stream()
                .map(mapper::mapDaoToDto).collect(Collectors.toList());
    }

    public DishDTO persistDish(DishDTO dto) {
        return Option.of(dto)
                .map(mapper::mapDtoToDao)
                .map(repository::save)
                .map(mapper::mapDaoToDto)
                .getOrElseThrow(RuntimeException::new);
    }
}
