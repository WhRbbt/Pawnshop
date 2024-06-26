package edu.vitiuk.pawnshop.controller;

import edu.vitiuk.pawnshop.service.PawnedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pawned-items")
public class PawnedItemController {
    private final PawnedItemService pawnedItemService;

    @Autowired
    public PawnedItemController(PawnedItemService pawnedItemService) {
        this.pawnedItemService = pawnedItemService;
    }

    @GetMapping
    public String listPawnedItems(Model model) {
        model.addAttribute("pawnedItems", pawnedItemService.findAll());
        return "pawned-items";
    }
}
