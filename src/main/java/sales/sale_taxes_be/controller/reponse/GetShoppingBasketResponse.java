package sales.sale_taxes_be.controller.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import sales.sale_taxes_be.controller.dto.ProductDTO;

import java.util.List;

@AllArgsConstructor
@Data
public class GetShoppingBasketResponse {
    private Long shoppingBasketId;
    private List<ProductDTO> products;
}
