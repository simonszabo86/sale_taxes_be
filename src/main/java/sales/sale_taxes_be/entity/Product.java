package sales.sale_taxes_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.type.TrueFalseConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_imported")
    @Convert(converter = TrueFalseConverter.class)
    private Boolean isImported;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductOfBasket> productOfBasketList = new ArrayList<>();

}
