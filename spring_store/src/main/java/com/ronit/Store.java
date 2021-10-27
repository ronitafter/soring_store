package com.ronit;

import java.sql.Date;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Scope;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ronit.beans.Customer;
import com.ronit.beans.Order;
import com.ronit.repositories.CustomersRepository;
import com.ronit.repositories.OrdersRepository;

//@Component
//@Scope("singleton")
@Service
@Transactional
public class Store {

	private CustomersRepository customersrepository;
	private OrdersRepository ordersrepository;

	@Autowired
	public Store(CustomersRepository customersrepository, OrdersRepository ordersrepository) {
		this.customersrepository = customersrepository;
		this.ordersrepository = ordersrepository;
	}

	public void addNewCustomer(Customer customer) {
		customersrepository.save(customer);
	}

	public List<Customer> getCustomerByAge(int age) {
		return customersrepository.findByAge(age);

	}

	public List<Customer> getCustomerByName(String name) {
		return customersrepository.findByName(name);

	}

	public Customer getCustomerById(long id) {
		return customersrepository.findById(id);

	}

	public List<Customer> getAllCustomers() {
		return customersrepository.findAll();

	}

	public List<Order> getAllOrders() {
		return ordersrepository.findAll();

	}

	public List<Order> getOrdersBetween2Dates(Date orderDate, Date orderDate2) {
		return ordersrepository.findByOrderDateBetween(orderDate, orderDate2);

	}
	
	public void addOrdersToCustomer(long customerId, List<Order> orders) {
		Customer customer = customersrepository.findById(customerId);
		orders.addAll(customer.getOrders());
		customer.setOrders(orders);
	}
	
	public void addOneOrderToCustomer(long customerId, Order order) {
		Customer customer = customersrepository.findById(customerId); // this customer object is persistent
		customer.addOrder(order);
	}
}
