package com.example.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Entity.Product;
import com.example.Repositry.ProductReposirty;

@RestController
public class CategoryController {
	@Autowired
	ProductReposirty productReposirty;
	@GetMapping(path = "/getphoto/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage( @PathVariable("id")  Long id) throws IOException {
		 Product p=productReposirty.findById(id).get();
	        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecomm-lightt/product/"+p.getPhotoname()));
	    }
	 @PostMapping(path = "/uploadPhoto/{id}")
	    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
	       Product p=productReposirty.findById(id).get();
	       p.setPhotoname(file.getOriginalFilename());
	       Files.write(Paths.get(System.getProperty("user.home")+"/ecomm-lightt/product/"+p.getPhotoname()),file.getBytes());
	       productReposirty.save(p);
	    }
		
	}


