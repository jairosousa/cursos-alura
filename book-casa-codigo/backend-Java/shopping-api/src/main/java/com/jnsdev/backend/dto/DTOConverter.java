package com.jnsdev.backend.dto;

import com.jnsdev.backend.dto.shopping.ItemDTO;
import com.jnsdev.backend.dto.shopping.ShopDTO;
import com.jnsdev.backend.model.Item;
import com.jnsdev.backend.model.Shop;

import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 13:27
 */
public class DTOConverter {

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(
                item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
