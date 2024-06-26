package edu.vitiuk.pawnshop.repository;

import edu.vitiuk.pawnshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
