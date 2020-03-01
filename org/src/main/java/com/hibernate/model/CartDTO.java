package com.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "cart")
public class CartDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;

	@Column(name = "total")
	private double total;

	@Column(name = "name")
	private String name;

	@OneToMany
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "cart_id")
	private Collection<ItemDTO> items = new ArrayList<ItemDTO>();

	public long getCartId() {
		return cartId;
	}

	public double getTotal() {
		return total;
	}

	public String getName() {
		return name;
	}

	public Collection<ItemDTO> getItems() {
		return items;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setName(String name) {
		this.name = name;
	}


}
