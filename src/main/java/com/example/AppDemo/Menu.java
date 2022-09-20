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
public class Menu {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String info;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MenuItem> items;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonGetter
    public Restaurant getRestaurant() {
        return restaurant;
    }
    @JsonSetter
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @JsonCreator
    public Menu(@JsonProperty("id") Long id, @JsonProperty("type") String type, @JsonProperty("info") String info, @JsonProperty("items") List<MenuItem> items) {
        this.id = id;
        this.type = type;
        this.info = info;
        if(items != null) {
            this.items = items;
            for(MenuItem item : items)
                item.setMenu(this);
        }
    }

    public Menu(Long id, String type, String info, Restaurant restaurant) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu [" +
                "id :" + id + '\'' +
                "type: " + type + '\'' +
                "items : " + items +
                '}';
    }
}
