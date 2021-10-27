package com.ronit.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ronit.beans.Customer;
import com.ronit.beans.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
	List<Order> findByOrderDateBetween(Date orderDate, Date orderDate2);
	List<Order> findById(int id);


	

}
