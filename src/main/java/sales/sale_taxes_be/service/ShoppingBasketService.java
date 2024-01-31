package sales.sale_taxes_be.service;

import sales.sale_taxes_be.entity.ShoppingBasket;

import java.util.Optional;

public interface ShoppingBasketService {
    Optional<ShoppingBasket> getShoppingBasket(Long id);
}
