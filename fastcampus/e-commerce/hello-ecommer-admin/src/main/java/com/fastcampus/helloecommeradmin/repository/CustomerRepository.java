package com.fastcampus.helloecommeradmin.repository;

import com.fastcampus.helloecommeradmin.domain.customer.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findTop100ByIsDeletedIsFalse();
}