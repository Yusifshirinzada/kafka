package com.producer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class Product {
    public String title;
    public String description;
    public String color;

    public int price;
    public boolean isInStock;


}
