package edu.vitiuk.pawnshop.repository;

import edu.vitiuk.pawnshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
