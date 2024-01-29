package sales.sale_taxes_be.controller;

import sales.sale_taxes_be.controller.reponse.GetAllProductsResponse;
import sales.sale_taxes_be.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sale_taxes_be.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public GetAllProductsResponse getAllProducts() {
        return new GetAllProductsResponse(productService.listAllProducts().stream().map(ProductMapper::toDTO).toList());
    }
}
