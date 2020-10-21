package com.kitopi.menu.repository;

import com.kitopi.menu.domain.DishesGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesGroupRepository extends JpaRepository<DishesGroup, Long> {
}