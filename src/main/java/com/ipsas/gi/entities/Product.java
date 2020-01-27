package com.ipsas.gi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String name;
	private int prix;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int code, String name, int prix) {
		super();
		this.code = code;
		this.name = name;
		this.prix = prix;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
}