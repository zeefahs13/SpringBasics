package com.springbasics.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "order",uniqueConstraints={@UniqueConstraint(columnNames={"orderId"})})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "orderId", updatable = false, nullable = false)
	private int orderId;
	
	@Column(name="orderNumber")
	private int orderNumber;
	
	@Column(name="orderAmount")
	private int orderAmount;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	

}
