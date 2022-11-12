package com.example.Repositry;

import java.util.List;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Entity.Product;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductReposirty extends JpaRepository<Product, Long> {
	@RestResource( path= "/sel")
	 public List<Product> findBySelectedIsTrue();
	@RestResource(path="/cher")
	@org.springframework.data.jpa.repository.Query(value = "select * from product p where p.name like:mc",nativeQuery = true)
	 public List<Product> findByNameContains( @Param("mc") String mc);

}
