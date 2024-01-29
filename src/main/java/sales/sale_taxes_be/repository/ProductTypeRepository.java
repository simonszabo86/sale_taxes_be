package sales.sale_taxes_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sales.sale_taxes_be.entity.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
