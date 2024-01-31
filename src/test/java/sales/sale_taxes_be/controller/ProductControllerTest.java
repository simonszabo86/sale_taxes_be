package sales.sale_taxes_be.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sales.sale_taxes_be.controller.dto.ProductDTO;
import sales.sale_taxes_be.controller.reponse.GetAllProductsResponse;
import sales.sale_taxes_be.entity.Product;
import sales.sale_taxes_be.entity.ProductType;
import sales.sale_taxes_be.entity.ProductTypeEnum;
import sales.sale_taxes_be.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = ProductController.class)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl productService;

    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    public void init () {
        ProductType productType = new ProductType(1L, ProductTypeEnum.BOOK, 1D, new ArrayList<>());
        product = new Product(1L, "book", 1D, false, productType, new ArrayList<>());
        productDTO = new ProductDTO();
    }

    @Test
    public void ProductController_GetAllProducts_ReturnProductsResponse() throws Exception {
        // Creating a mock response DTO
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        Collections.addAll(productDTOList, productDTO, productDTO, productDTO);
        Collections.addAll(productList, product, product, product);
        GetAllProductsResponse getAllProductsResponse = new GetAllProductsResponse(productDTOList);

        // Mocking the service behavior
        when(productService.listAllProducts()).thenReturn(productList);

        // Performing an HTTP GET request to get products
        ResultActions response = mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON));

        // Asserting the response expectations
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products.size()", CoreMatchers.is(getAllProductsResponse.getProducts().size())));
    }
}
