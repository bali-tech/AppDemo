package com.example.AppDemo;

import javax.persistence.*;
import java.awt.*;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Menu> menus;

    @JsonCreator
    public Restaurant(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("location") String location,
                      @JsonProperty("menus") List<Menu> menus) {
        this.name = name;
        this.location = location;

        if (menus !=null) {
            this.menus = menus;
            for(Menu menu : menus)
                menu.setRestaurant(this);
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id : " + id + ", " +
                "Name :" + name + ", " +
                "Location : " + location + ", " +
                "Menu : " + menus +
                '}';
    }
}
