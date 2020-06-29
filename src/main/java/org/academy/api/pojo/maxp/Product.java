package org.academy.api.pojo.maxp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;
    private Integer idGroup;
    private String name;
    private String description;
    private String manufacturer;
    private Integer quantity;
    private double price;

}
