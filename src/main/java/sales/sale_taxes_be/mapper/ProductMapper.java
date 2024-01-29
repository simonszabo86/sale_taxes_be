package sales.sale_taxes_be.mapper;

import sales.sale_taxes_be.controller.dto.ProductDTO;
import sales.sale_taxes_be.entity.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductMapper {

    private static final Double importTax = 0.05;
    private static final Double round = 0.05;

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .productType(product.getProductType().getType())
                .title(product.getTitle())
                .price(product.getPrice())
                .shelfPrice(calculateSalePrice(product))
                .build();
    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        return roundToNearest(bd, new BigDecimal(Double.toString(round))).doubleValue();
    }

    private static BigDecimal roundToNearest(BigDecimal number, BigDecimal increment) {
        return number.divide(increment, 0, RoundingMode.UP).multiply(increment);
    }

    private static Double calculateSalePrice(Product product) {
        Double tax = product.getProductType().getTax();
        if(tax != 1 || product.getIsImported()){
            if (product.getIsImported()) {
                tax += importTax;
            }
            double newPrice = product.getPrice() * tax;
            return round(newPrice);
        }
        return product.getPrice();
    }


}
