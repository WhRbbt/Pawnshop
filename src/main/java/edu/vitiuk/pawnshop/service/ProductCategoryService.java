package edu.vitiuk.pawnshop.service;

import edu.vitiuk.pawnshop.entity.ProductCategory;
import edu.vitiuk.pawnshop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public void save(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public ProductCategory findById(Long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
