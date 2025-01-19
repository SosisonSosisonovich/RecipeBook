package com.example.RecipeBook.Entity;

import lombok.Data;

@Data
public class RecipeDTO {
    private Integer category; // Здесь только ID категории
    private String name;
    private String time;
    private String text;
}