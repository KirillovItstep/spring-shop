package org.itstep.helloworldspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelryBase {
    private Long id;
    private String name;
    private String color;
    private double price;
    private double priceNew;
    @Transient
    private String image;
}
