package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.ShopDTO;
import com.jnsdev.backend.dto.ShopReportDTO;
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

    public List<ShopDTO> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(Date date) {
        return shopRepository.findAllByDateGreaterThanEqual(date)
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(Long productId) {
        Optional<Shop> shop = shopRepository.findById(productId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO
                .getItems()
                .stream().map(itemDTO -> itemDTO.getPrice())
                .reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);

        return ShopDTO.convert(shop);
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
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(
            Date dataInicio,
            Date dataFim) {
        return shopRepository
                .getReportByDate(dataInicio, dataFim);
    }
}
