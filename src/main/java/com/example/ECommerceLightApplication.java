package com.example;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.Entity.Category;
import com.example.Entity.Product;
import com.example.Repositry.CategoryRepositry;
import com.example.Repositry.ProductReposirty;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ECommerceLightApplication implements CommandLineRunner {
	@Autowired
	CategoryRepositry categoryRepositry;
	@Autowired
	ProductReposirty productReposirty;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceLightApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		repositoryRestConfiguration.exposeIdsFor(Category.class);
		categoryRepositry.save( new Category(null, "smart", null, null,null));
		categoryRepositry.save( new Category(null, "ordinateur", null,null, null));
		categoryRepositry.save( new Category(null, "printer", null,null, null));
		Random rnd=new Random();
		categoryRepositry.findAll().forEach(c->{
			for(int i=0;i<10;i++) {
				Product product=new Product();
				product.setCategory(c);
				product.setName(RandomString.make(18));
			//	product.setAvaliable(rnd.nextBoolean());
				product.setAvaliable(rnd.nextBoolean());
				product.setName(RandomString.make(18));
				product.setPrice(rnd.nextInt(10000)+100);
				product.setPhotoname("uknown.png");
				product.setPromotion(rnd.nextBoolean());
				product.setPromotion(rnd.nextBoolean());
				product.setSelected(rnd.nextBoolean());
				productReposirty.save(product);
			}});
			
		}
			}
		
	

