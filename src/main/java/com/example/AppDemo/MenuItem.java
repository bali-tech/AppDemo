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
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String info;
    private String imageUrl;
    private Double price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="menu_id")
    private Menu menu;

    public MenuItem(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("info") String info,
                    @JsonProperty("imageUrl") String imageUrl, @JsonProperty("price") Double price) {

        this.id = id;
        this.name = name;
        this.info = info;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "Id : " + id + "," +
                "Name: " + name + "," +
                "Image URL : " + imageUrl + "," +
                "Price : " + price + '}';
    }
}
