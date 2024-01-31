package sales.sale_taxes_be.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import sales.sale_taxes_be.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
public class ShoppingBasketRepositoryTest {

    @Autowired
    private ShoppingBasketRepository shoppingBasketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOfBasketRepository productOfBasketRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;


    private ShoppingBasket shoppingBasket1;
    private ShoppingBasket shoppingBasket2;
    private Product product2;

    @BeforeEach
    public void initTestData(){
        ProductType productType1 = new ProductType(1L, ProductTypeEnum.BOOK, 1D, new ArrayList<>());
        ProductType productType2 = new ProductType(2L, ProductTypeEnum.PERFUME, 1.1D, new ArrayList<>());

        Product product1 = new Product(1L, "book", 12.49D, false, productType1, new ArrayList<>());
        product2 = new Product(2L, "parfume", 18.1D, true, productType2, new ArrayList<>());

        ProductOfBasket productOfBasket1 = new ProductOfBasket(1L, product1, new ShoppingBasket());
        List<ProductOfBasket> productOfBasketList1 = new ArrayList<>();
        Collections.addAll(productOfBasketList1, productOfBasket1);
        shoppingBasket1 = new ShoppingBasket(1L, productOfBasketList1);

        ProductOfBasket productOfBasket2 = new ProductOfBasket(2L, product2, new ShoppingBasket());
        List<ProductOfBasket> productOfBasketList2 = new ArrayList<>();
        Collections.addAll(productOfBasketList2, productOfBasket2);
        shoppingBasket2 = new ShoppingBasket(2L, productOfBasketList2);

        productTypeRepository.save(productType1);
        productRepository.save(product1);
        productOfBasketRepository.save(productOfBasket1);

        productTypeRepository.save(productType2);
        productRepository.save(product2);
        productOfBasketRepository.save(productOfBasket2);
    }

    @Test
    @DisplayName("Test for ShoppingBasket save")
    public void givenShoppingBasket_whenSave_thenReturnSaveShoppingBasket(){
        // When
        ShoppingBasket savedShoppingBasket = shoppingBasketRepository.save(shoppingBasket1);

        //Then
        assertThat(savedShoppingBasket).isNotNull();
        assertThat(savedShoppingBasket.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test for ShoppingBasket findById")
    public void givenShoppingBasket_whenFindById_thenReturnShoppingBasket()
    {
        // Given
        shoppingBasketRepository.save(shoppingBasket1);
        shoppingBasketRepository.save(shoppingBasket2);

        // When
        Optional<ShoppingBasket> shoppingBasket = shoppingBasketRepository.findById(product2.getId());

        // Then
        Assertions.assertTrue(shoppingBasket.isPresent());
        assertThat(shoppingBasket.get().getId()).isEqualTo(shoppingBasket2.getId());
        assertThat(shoppingBasket.get().getProductOfBasketList().get(0).getProduct()).usingRecursiveComparison().isEqualTo(product2);
    }
}
