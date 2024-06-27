package edu.vitiuk.pawnshop.controller;

import edu.vitiuk.pawnshop.entity.PawnedItem;
import edu.vitiuk.pawnshop.service.CustomerService;
import edu.vitiuk.pawnshop.service.PawnedItemService;
import edu.vitiuk.pawnshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pawned-items")
public class PawnedItemController {
    private final PawnedItemService pawnedItemService;
    private final ProductCategoryService productCategoryService;
    private final CustomerService customerService;

    @Autowired
    public PawnedItemController(PawnedItemService pawnedItemService,
                                ProductCategoryService productCategoryService,
                                CustomerService customerService) {
        this.pawnedItemService = pawnedItemService;
        this.productCategoryService = productCategoryService;
        this.customerService = customerService;
    }

    @GetMapping
    public String listPawnedItems(Model model) {
        model.addAttribute("pawnedItems", pawnedItemService.findAll());
        return "pawned-items";
    }

    @GetMapping("/add")
    public String showAddPawnedItemForm(Model model) {
        model.addAttribute("pawnedItem", new PawnedItem());
        model.addAttribute("productCategories", productCategoryService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "add-pawned-item";
    }

    @PostMapping("/add")
    public String addPawnedItem(@ModelAttribute PawnedItem pawnedItem) {
        pawnedItemService.save(pawnedItem);
        return "redirect:/pawned-items";
    }

    @GetMapping("/edit/{id}")
    public String showEditPawnedItemForm(@PathVariable Long id, Model model) {
        PawnedItem pawnedItem = pawnedItemService.findById(id);
        model.addAttribute("pawnedItem", pawnedItem);
        model.addAttribute("productCategories", productCategoryService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "edit-pawned-item";
    }

    @PostMapping("/edit/{id}")
    public String updatePawnedItem(@PathVariable Long id, @ModelAttribute PawnedItem pawnedItem) {
        pawnedItem.setId(id);
        pawnedItemService.save(pawnedItem);
        return "redirect:/pawned-items";
    }

    @GetMapping("/delete/{id}")
    public String deletePawnedItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        pawnedItemService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Customer successfully deleted.");
        return "redirect:/pawned-items";
    }
}
