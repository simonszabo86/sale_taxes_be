package sales.sale_taxes_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sale_taxes_be.controller.dto.ProductDTO;
import sales.sale_taxes_be.controller.reponse.GetShoppingBasketResponse;
import sales.sale_taxes_be.entity.ProductOfBasket;
import sales.sale_taxes_be.entity.ShoppingBasket;
import sales.sale_taxes_be.mapper.ProductMapper;
import sales.sale_taxes_be.service.ShoppingBasketService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/basket")
public class ShoppingBasketController {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<GetShoppingBasketResponse> getShoppingBasket(@PathVariable("id") Long id) {
        Optional<ShoppingBasket> shoppingBasket = shoppingBasketService.getShoppingBasket(id);
        if (shoppingBasket.isPresent()) {
            List<ProductOfBasket> productOfBasketList = shoppingBasket.get().getProductOfBasketList();
            List<ProductDTO> productDTOList = productOfBasketList.stream().map((ProductOfBasket pOB) -> ProductMapper.toDTO(pOB.getProduct())).toList();
            return ResponseEntity.ok().body(new GetShoppingBasketResponse(shoppingBasket.get().getId(), productDTOList));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
