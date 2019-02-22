package com.firstJavaspringwar.vivek.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id" )
	private long id;
	
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="cust_email")
	private String email;
	
	@Column(name="cust_address")
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="txn_id")
	private Txn txn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Txn getTxn() {
		return txn;
	}
	public void setTxn(Txn txn) {
		this.txn = txn;
	}
	public Customer() {
		super();
	}
	public Customer(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
}