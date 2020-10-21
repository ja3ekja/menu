package com.kitopi.menu.service;

import com.kitopi.menu.domain.dto.DishDTO;
import com.kitopi.menu.domain.dto.DishesGroupDTO;
import com.kitopi.menu.mapper.DishesGroupMapper;
import com.kitopi.menu.repository.DishesGroupRepository;
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
public class DishesGroupService {

    private final DishesGroupMapper mapper;
    private final DishesGroupRepository repository;

    public List<DishesGroupDTO> getDishesGroup() {
        return repository.findAll().stream()
                .map(mapper::mapDaoToDto).collect(Collectors.toList());
    }

}
