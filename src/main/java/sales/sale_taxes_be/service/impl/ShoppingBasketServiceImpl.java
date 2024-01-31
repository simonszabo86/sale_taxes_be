package sales.sale_taxes_be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.sale_taxes_be.entity.ShoppingBasket;
import sales.sale_taxes_be.repository.ShoppingBasketRepository;
import sales.sale_taxes_be.service.ShoppingBasketService;

import java.util.Optional;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    @Autowired
    ShoppingBasketRepository shoppingBasketRepository;

    public Optional<ShoppingBasket> getShoppingBasket(Long id) {
        return shoppingBasketRepository.findById(id);
    }


}
