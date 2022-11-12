package com.example.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Entity.Category;
@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepositry extends JpaRepository<Category, Long> {

}
