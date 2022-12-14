package com.example.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data  @AllArgsConstructor @NoArgsConstructor
public class Category implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String photo;
	@OneToMany(mappedBy ="category")
	private Collection<Product> products;

}
