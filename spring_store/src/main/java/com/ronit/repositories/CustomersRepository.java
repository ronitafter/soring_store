package com.ronit.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ronit.beans.Customer;
import com.ronit.beans.Order;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer>{
	List<Customer> findByName(String name);
	List<Customer> findByAge(int age);
	Customer  findById(long id);

}
