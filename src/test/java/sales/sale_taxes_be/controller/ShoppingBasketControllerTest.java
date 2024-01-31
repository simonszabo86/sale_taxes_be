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
import sales.sale_taxes_be.controller.reponse.GetShoppingBasketResponse;
import sales.sale_taxes_be.entity.*;
import sales.sale_taxes_be.service.impl.ShoppingBasketServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShoppingBasketController.class)
@ExtendWith(MockitoExtension.class)
public class ShoppingBasketControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ShoppingBasketServiceImpl shoppingBasketService;

    private ProductOfBasket productOfBasket;

    @BeforeEach
    public void init() {
        ProductType productType = new ProductType(1L, ProductTypeEnum.BOOK, 1D, new ArrayList<>());
        Product product = new Product(1L, "book", 1D, false, productType, new ArrayList<>());
        productOfBasket = new ProductOfBasket(1L, product, new ShoppingBasket());
    }

    @Test
    public void ShoppingBasketController_GetShoppingBasket_ReturnGetShoppingBasketResponse() throws Exception {

        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductOfBasket> productOfBasketList = new ArrayList<>();

        Collections.addAll(productDTOList, new ProductDTO());
        Collections.addAll(productOfBasketList, productOfBasket);
        ShoppingBasket shoppingBasket = new ShoppingBasket(1L, productOfBasketList);
        GetShoppingBasketResponse getShoppingBasketResponse = new GetShoppingBasketResponse(1L, productDTOList);

        // Mocking the service behavior
        when(shoppingBasketService.getShoppingBasket(1L)).thenReturn(Optional.of(shoppingBasket));

        // Performing an HTTP GET request to get ShoppingBasket
        ResultActions response = mockMvc.perform(get("/api/basket/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        // Asserting the response expectations
        response.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products.size()", CoreMatchers.is(getShoppingBasketResponse.getProducts().size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.products[0].title", CoreMatchers.is("book")));

    }
}
