package sales.sale_taxes_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "shopping_basket")
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shoppingBasket", fetch = FetchType.EAGER)
    private List<ProductOfBasket> productOfBasketList = new ArrayList<>();
}
