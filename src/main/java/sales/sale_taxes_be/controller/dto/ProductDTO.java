package sales.sale_taxes_be.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sales.sale_taxes_be.entity.ProductTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    private ProductTypeEnum productType;

    private String title;

    private Double price;

    private Double shelfPrice;

}
