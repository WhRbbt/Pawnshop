package edu.vitiuk.pawnshop.controller;

import edu.vitiuk.pawnshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public String listProductCategories(Model model) {
        model.addAttribute("productCategories", productCategoryService.findAll());
        return "product-categories";
    }
}
