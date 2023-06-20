package com.jnsdev.backend.model;

import com.jnsdev.backend.dto.shopping.ItemDTO;

import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 07:49
 */
@Embeddable
@Table(name = "item", schema = "shopping")
public class Item {

    private String productIdentifier;
    
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(
                itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
