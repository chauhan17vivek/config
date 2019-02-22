package com.firstJavaspringwar.vivek.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cart_id")
	private long id;
    
    @Column(name="total")
	private double total;
    
    @ManyToMany(targetEntity=Item.class,cascade= {CascadeType.ALL})
    @JoinTable(name="Cart_Items",joinColumns= {@JoinColumn(name="cart_id")},inverseJoinColumns= {@JoinColumn(name="item_id")})
	private Set<Item> items;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	 
	
	
}
