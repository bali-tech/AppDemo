package com.example.AppDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.AppDemo.MenuItemRepository;
import com.example.AppDemo.MenuItem;

import java.util.List;
@RestController
@RequestMapping("/menuItems")

public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping("/")
    public List<MenuItem> getMenuItems() {
        return menuItemRepo.findAll();
    }

    @GetMapping("/{id}")
    public MenuItem findMenuById(@PathVariable("id") Long id) {
        return menuItemRepo.findOne(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItemList) {
        menuItemRepo.save(menuItemList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        menuItemRepo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        menuItemRepo.delete(id);
    }
}


