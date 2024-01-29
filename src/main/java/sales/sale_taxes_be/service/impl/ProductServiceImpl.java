package sales.sale_taxes_be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.sale_taxes_be.entity.Product;
import sales.sale_taxes_be.repository.ProductRepository;
import sales.sale_taxes_be.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

}
