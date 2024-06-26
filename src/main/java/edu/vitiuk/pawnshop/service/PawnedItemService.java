package edu.vitiuk.pawnshop.service;

import edu.vitiuk.pawnshop.entity.PawnedItem;
import edu.vitiuk.pawnshop.repository.PawnedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnedItemService {
    private final PawnedItemRepository pawnedItemRepository;

    @Autowired
    public PawnedItemService(PawnedItemRepository pawnedItemRepository) {
        this.pawnedItemRepository = pawnedItemRepository;
    }

    public List<PawnedItem> findAll() {
        return pawnedItemRepository.findAll();
    }

    public void save(PawnedItem pawnedItem) {
        pawnedItemRepository.save(pawnedItem);
    }

    public PawnedItem findById(Long id) {
        return pawnedItemRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        pawnedItemRepository.deleteById(id);
    }
}
