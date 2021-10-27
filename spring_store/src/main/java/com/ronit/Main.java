package com.ronit;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ronit.beans.Customer;
import com.ronit.beans.Order;
import com.ronit.repositories.CustomersRepository;
import com.ronit.repositories.OrdersRepository;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Main.class);
		CustomersRepository customersrepository = context.getBean(CustomersRepository.class);
		OrdersRepository ordersrepository = context.getBean(OrdersRepository.class);
		
//		{ // add new customer + orders
			List<Order> orders = new ArrayList<>();
			
			Date orderDate = java.sql.Date.valueOf("2021-11-11");
			orders.add(new Order("tttt", orderDate));
			orders.add(new Order("ccc", orderDate));
		ordersrepository.save(new Order("tttt", orderDate));
			
			Customer customer = new Customer(3,"hhh", 25, null);
			customer.setOrders(orders);
			customersrepository.save(customer);
//		}
		
//		{ // get an existing customer and add orders
//			
//			Customer customer = customersrepository.findById(1);
//			System.out.println(customer);
//			
//			Order order1 = new Order("aaa", Date.valueOf(LocalDate.of(2021, 10, 20)));
//			Order order2 = new Order("bbb", Date.valueOf(LocalDate.of(2021, 10, 15)));
//			List<Order> list = new ArrayList<Order>();
//			list.add(order1);
//			list.add(order2);
//			customer.setOrders(list);
//			customersrepository.save(customer);
//			
//		}
		
//		{ // add orders
//			Store store = context.getBean(Store.class);
//			Order order1 = new Order("AAA5", Date.valueOf(LocalDate.of(2021, 10, 20)));
//			Order order2 = new Order("AAA6", Date.valueOf(LocalDate.of(2021, 10, 15)));
//			List<Order> list = new ArrayList<Order>();
//			list.add(order1);
//			list.add(order2);
//			store.addOrdersToCustomer(1, list);
//			
//		}
		{ // add one order
//			Store store = context.getBean(Store.class);
//			Order order1 = new Order("AAA5", Date.valueOf(LocalDate.of(2021, 10, 20)));
//			Order order2 = new Order("AAA6", Date.valueOf(LocalDate.of(2021, 10, 15)));
//			Order order3 = new Order("AAA7", Date.valueOf(LocalDate.of(2021, 10, 15)));
//
//			store.addOneOrderToCustomer(1,order1);
//			store.addOneOrderToCustomer(1,order2);
//			store.addOneOrderToCustomer(1,order3);

			
		}
		

	}

}
