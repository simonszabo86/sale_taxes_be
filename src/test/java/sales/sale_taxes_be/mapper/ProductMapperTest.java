package sales.sale_taxes_be.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sales.sale_taxes_be.controller.dto.ProductDTO;
import sales.sale_taxes_be.entity.Product;
import sales.sale_taxes_be.entity.ProductType;
import sales.sale_taxes_be.entity.ProductTypeEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    ProductType bookType = new ProductType(1L, ProductTypeEnum.BOOK, 1D, new ArrayList<>());
    ProductType entertainmentType = new ProductType(2L, ProductTypeEnum.ENTERTAINMENT, 1.1D, new ArrayList<>());
    ProductType foodType = new ProductType(3L, ProductTypeEnum.FOOD, 1D, new ArrayList<>());

    ProductType perfumeType = new ProductType(4L, ProductTypeEnum.PERFUME, 1.1D, new ArrayList<>());
    ProductType medicineType = new ProductType(5L, ProductTypeEnum.MEDICINE, 1D, new ArrayList<>());

    @DisplayName("test mapping with only not imported products")
    @Test
    public void whenProductAreNotImported_mappingLogicShouldWorkCorrectly() {

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1L, "book", 12.49, false, bookType, new ArrayList<>());
        Product product2 = new Product(2L, "music CD", 14.99, false, entertainmentType, new ArrayList<>());
        Product product3 = new Product(3L, "chocolate bar", 0.85, false, foodType, new ArrayList<>()) ;
        Collections.addAll(productList, product1, product2, product3);

        List<ProductDTO> productDTOList = productList.stream().map(ProductMapper::toDTO).toList();

        ProductDTO productDTO1 = new ProductDTO(1L, ProductTypeEnum.BOOK, "book", 12.49, 12.49);
        ProductDTO productDTO2 = new ProductDTO(2L, ProductTypeEnum.ENTERTAINMENT, "music CD", 14.99, 16.5);
        ProductDTO productDTO3 = new ProductDTO(3L, ProductTypeEnum.FOOD, "chocolate bar", 0.85, 0.85);

        assertEquals(productDTOList.get(0), productDTO1);
        assertEquals(productDTOList.get(1), productDTO2);
        assertEquals(productDTOList.get(2), productDTO3);
    }

    @DisplayName("test mapping with only imported products")
    @Test
    public void whenProductAreImported_mappingLogicShouldWorkCorrectly() {

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1L, "imported box of chocolates", 10.00, true, foodType, new ArrayList<>());
        Product product2 = new Product(2L, "imported bottle of perfume", 47.50, true, perfumeType, new ArrayList<>());
        Collections.addAll(productList, product1, product2);

        List<ProductDTO> productDTOList = productList.stream().map(ProductMapper::toDTO).toList();

        ProductDTO productDTO1 = new ProductDTO(1L, ProductTypeEnum.FOOD, "imported box of chocolates", 10.0, 10.5);
        ProductDTO productDTO2 = new ProductDTO(2L, ProductTypeEnum.PERFUME, "imported bottle of perfume", 47.5, 54.65);

        assertEquals(productDTOList.get(0), productDTO1);
        assertEquals(productDTOList.get(1), productDTO2);
    }

    @DisplayName("test mapping with both imported and not imported products")
    @Test
    public void whenProductAreBothImportedAndNotImported_mappingLogicShouldWorkCorrectly() {

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1L, "imported bottle of perfume", 27.99, true, perfumeType, new ArrayList<>());
        Product product2 = new Product(2L, "bottle of perfume", 18.99, false, perfumeType, new ArrayList<>());
        Product product3 = new Product(3L, "packet of headache pills", 9.75, false, medicineType, new ArrayList<>());
        Product product4 = new Product(4L, "box of imported chocolates", 11.25, true, foodType, new ArrayList<>());
        Collections.addAll(productList, product1, product2, product3, product4);

        List<ProductDTO> productDTOList = productList.stream().map(ProductMapper::toDTO).toList();

        ProductDTO productDTO1 = new ProductDTO(1L, ProductTypeEnum.PERFUME, "imported bottle of perfume", 27.99, 32.2);
        ProductDTO productDTO2 = new ProductDTO(2L, ProductTypeEnum.PERFUME, "bottle of perfume", 18.99, 20.9);
        ProductDTO productDTO3 = new ProductDTO(3L, ProductTypeEnum.MEDICINE, "packet of headache pills", 9.75, 9.75);
        ProductDTO productDTO4 = new ProductDTO(4L, ProductTypeEnum.FOOD, "box of imported chocolates", 11.25, 11.85);

        assertEquals(productDTOList.get(0), productDTO1);
        assertEquals(productDTOList.get(1), productDTO2);
        assertEquals(productDTOList.get(2), productDTO3);
        assertEquals(productDTOList.get(3), productDTO4);
    }
}
