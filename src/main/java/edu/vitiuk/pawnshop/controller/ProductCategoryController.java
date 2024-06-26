package edu.vitiuk.pawnshop.controller;

import edu.vitiuk.pawnshop.entity.ProductCategory;
import edu.vitiuk.pawnshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String showAddProductCategoryForm(Model model) {
        model.addAttribute("productCategory", new ProductCategory());
        return "add-product-category";
    }

    @PostMapping("/add")
    public String addProductCategory(@ModelAttribute ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return "redirect:/product-categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductCategoryForm(@PathVariable Long id, Model model) {
        ProductCategory productCategory = productCategoryService.findById(id);
        model.addAttribute("productCategory", productCategory);
        return "edit-product-category";
    }

    @PostMapping("/edit/{id}")
    public String updateProductCategory(@PathVariable Long id, @ModelAttribute ProductCategory productCategory) {
        productCategory.setId(id);
        productCategoryService.save(productCategory);
        return "redirect:/product-categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductCategory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productCategoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Customer successfully deleted.");
        return "redirect:/product-categories";
    }
}
