package com.weshopify.platform.features.customers.repo;

import org.springframework.data.repository.CrudRepository;

import com.weshopify.platform.features.customers.domain.Customer;


public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
