package com.kitopi.menu.service;

import com.kitopi.menu.domain.dto.ComboDTO;
import com.kitopi.menu.mapper.ComboMapper;
import com.kitopi.menu.repository.ComboRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComboService {


    private final ComboMapper mapper;
    private final ComboRepository repository;


    public Option<ComboDTO> getCombo(Long comboId) {
        return Option.ofOptional(repository.findById(comboId))
                .map(mapper::mapDaoToDto);
    }

    public List<ComboDTO> getCombos() {
        return repository.findAll().stream()
                .map(mapper::mapDaoToDto).collect(Collectors.toList());
    }

    public ComboDTO persistCombo(ComboDTO dto) {
        return Option.of(dto)
                .map(mapper::mapDtoToDao)
                .map(repository::save)
                .map(mapper::mapDaoToDto)
                .getOrElseThrow(RuntimeException::new);
    }
}
