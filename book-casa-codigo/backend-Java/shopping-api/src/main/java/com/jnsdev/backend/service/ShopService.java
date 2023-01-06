package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.DTOConverter;
import com.jnsdev.backend.dto.ShopReportDTO;
import com.jnsdev.backend.dto.product.ProductDTO;
import com.jnsdev.backend.dto.shopping.ItemDTO;
import com.jnsdev.backend.dto.shopping.ShopDTO;
import com.jnsdev.backend.model.Shop;
import com.jnsdev.backend.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 08:06
 */
@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public List<ShopDTO> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(Date date) {
        return shopRepository.findAllByDateGreaterThanEqual(date)
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(Long productId) {
        Optional<Shop> shop = shopRepository.findById(productId);
        if (shop.isPresent()) {
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        if (userService
                .getUserByCpf(shopDTO.getUserIdentifier()) == null) {
            return null;
        }

        if (!validateProducts(shopDTO.getItems())) {
            return null;
        }

        shopDTO.setTotal(shopDTO
                .getItems()
                .stream().map(itemDTO -> itemDTO.getPrice())
                .reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);

        return DTOConverter.convert(shop);
    }

    private boolean validateProducts(List<ItemDTO> items) {
        for (ItemDTO item : items) {
            ProductDTO productDTO = productService
                    .getProductByIdentifier(item.getProductIdentifier());
            if (productDTO == null) {
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }



    public List<ShopDTO> getShopsByFilter(
            Date dataInicio,
            Date dataFim,
            Float valorMinimo) {

        List<Shop> shops =
                shopRepository
                        .getShopByFilters(dataInicio, dataFim, valorMinimo);

        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(
            Date dataInicio,
            Date dataFim) {
        return shopRepository
                .getReportByDate(dataInicio, dataFim);
    }
}
