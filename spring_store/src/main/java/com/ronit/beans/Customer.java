package com.ronit.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
//	@Column(name = "name")
	private String name;
	private int age;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinColumn(name="customer_id")
	private List<Order> orders;
	
	public Customer() {
	
	}
	
	public Customer(String name, int age, List<Order> orders) {
		this.name = name;
		this.age = age;
		this.orders = orders;
		
	}
	
	public Customer(long id, String name, int age, List<Order> orders) {
		this(name, age, orders);
		this.id = id;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		if(this.orders == null) {
			this.orders = new ArrayList<Order>();
		}
		this.orders.add(order);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", orders=" + orders + "]";
	}
	
	

}
