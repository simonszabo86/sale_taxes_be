package sales.sale_taxes_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sales.sale_taxes_be.entity.ProductOfBasket;

@Repository
public interface ProductOfBasketRepository extends JpaRepository<ProductOfBasket, Long> {

}
