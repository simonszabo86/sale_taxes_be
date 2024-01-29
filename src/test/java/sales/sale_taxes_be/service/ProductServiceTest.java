package sales.sale_taxes_be.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sales.sale_taxes_be.entity.Product;
import sales.sale_taxes_be.entity.ProductType;
import sales.sale_taxes_be.entity.ProductTypeEnum;
import sales.sale_taxes_be.repository.ProductRepository;
import sales.sale_taxes_be.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @DisplayName("JUnit test for listAllProducts method with empty list")
    @Test
    public void whenProductRepositoryGivesEmptyList_thenReturnListOfProducts() {
        Mockito.when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<Product> result = productService.listAllProducts();
        assertTrue(result.isEmpty());
    }

    @DisplayName("JUnit test for listAllProducts method with product")
    @Test
    public void whenProductListGivesProducts_thenReturnTheSameProducts() {

        ProductType productType1 = new ProductType(1L, ProductTypeEnum.BOOK, 1D, new ArrayList<>());
        Product product1 = new Product(1L, "book", 12.49, false, productType1);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);

        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> result = productService.listAllProducts();
        assertEquals(productList, result);
    }
}
