package sales.sale_taxes_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sale_taxes_be.entity.ShoppingBasket;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
}
