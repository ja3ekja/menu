package com.kitopi.menu.repository;

import com.kitopi.menu.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
