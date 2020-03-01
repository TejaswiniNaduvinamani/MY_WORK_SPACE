package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "item_total")
	private double itemTotal;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartDTO cart;

	public ItemDTO() {

	}

	public ItemDTO(String itemId, double itemTotal, int quantity, CartDTO cart) {
		this.itemId = itemId;
		this.itemTotal = itemTotal;
		this.quantity = quantity;
		this.cart = cart;
	}

	public long getId() {
		return id;
	}

	public String getItemId() {
		return itemId;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

}
