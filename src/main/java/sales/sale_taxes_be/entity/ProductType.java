package sales.sale_taxes_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type_type")
    private ProductTypeEnum type;

    @Column(name = "tax")
    private Double tax;

    @ToString.Exclude
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();


}
