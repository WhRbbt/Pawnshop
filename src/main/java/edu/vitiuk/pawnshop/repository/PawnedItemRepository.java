package edu.vitiuk.pawnshop.repository;

import edu.vitiuk.pawnshop.entity.PawnedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PawnedItemRepository extends JpaRepository<PawnedItem, Long> {
}
