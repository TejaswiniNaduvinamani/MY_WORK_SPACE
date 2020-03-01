package com.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CART_SHOP")
public class CartShopDTO {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cart_total")
	private double total;

	@ManyToMany(targetEntity = ItemShopDTO.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "CART_ITEMS", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private Set<ItemShopDTO> items;

	public long getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public Set<ItemShopDTO> getItems() {
		return items;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setItems(Set<ItemShopDTO> items) {
		this.items = items;
	}

}
