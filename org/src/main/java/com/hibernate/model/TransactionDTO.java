package com.hibernate.model;

import java.io.Serializable;
import org.hibernate.annotations.CascadeType;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "TRANSACTION")
public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "txn_id")
	private long id;

	@Column(name = "txn_date")
	private Date date;

	@Column(name = "txn_total")
	private double total;

	@OneToOne(mappedBy = "txn")
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private CustomerDTO customer;

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public double getTotal() {
		return total;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return id + ", " + total + ", " + customer.getName() + ", " + customer.getEmail() + ", "
				+ customer.getAddress();
	}

}
