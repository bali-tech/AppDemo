package com.example.AppDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.AppDemo.Menu;
import com.example.AppDemo.MenuRepository;
import com.example.AppDemo.MenuItemRepository;
import com.example.AppDemo.MenuItem;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class MenuController {

    @Autowired
    private MenuRepository menuRepo;

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping("/")
    public List<Menu> getMenus() {
        return menuRepo.findAll();
    }

    @GetMapping("/{id}")
    public Menu findMenuById(@PathVariable("id") Long id) {
        return menuRepo.findOne(id);
    }

    @PostMapping("/")
    public void deleteAll() {
        log.info("delete All Menus: ");
        menuRepo.deleteAll();
    }

    @DeleteMapping("/{id")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("Delete menu by id: " + id);
        menuRepo.delete(id);
    }

    @RequestMapping("/{id}/items/")
    public List<MenuItem> getItems(@PathVariable("id") Long id) {

    }

}
