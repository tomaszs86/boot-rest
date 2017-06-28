package pl.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.boot.rest.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByProductCode(String productCode);
}
