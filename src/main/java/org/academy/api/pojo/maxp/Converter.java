package org.academy.api.pojo.maxp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Converter {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Product product = Product.builder()
                .id(1)
                .idGroup(1)
                .name("Lego Technick")
                .description("Perfect for small inventors")
                .manufacturer("Lego")
                .quantity(45)
                .price(11400)
                .build();

        String jsonInString = objectMapper.writeValueAsString(product);
        log.info(jsonInString);
        //System.out.println(jsonInString);

    }
}
