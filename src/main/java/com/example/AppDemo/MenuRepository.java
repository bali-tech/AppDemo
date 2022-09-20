package com.example.AppDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findRestaurant_Id (Long id);

    void deleteRestaurant_Id(Long id);
}
