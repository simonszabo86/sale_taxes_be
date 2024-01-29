package sales.sale_taxes_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TrueFalseConverter;

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

}
