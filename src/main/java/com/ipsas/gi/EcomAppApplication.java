package com.ipsas.gi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.util.Loader;
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
		
	interface ProductRepository extends JpaRepository<Product, Long>{
		
	}
	
	@RestController
	class ProductController{
		@Autowired
		private ProductRepository productRepository;
		@GetMapping("/index")
		public String index(Model model){
			model.addAttribute("products", productRepository.findAll());
			return "index";
		}
		
	}
		

@Configuration
@EnableAutoConfiguration
public class EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomAppApplication.class, args);
	}
	
	@Bean
	 public CommandLineRunner start(ProductRepository productRepository) {
		
		return args ->{
		  
			  productRepository.save(new Product( (Integer)null,"HtP",44));
			  productRepository.save(new Product((Integer) null,"HP",448));
			  productRepository.save(new Product((Integer)null,"HPYYY",445)); 
			  productRepository.save(new Product((Integer)null,"HPDDD",44));
			  productRepository.findAll().forEach(p->{
		
		 System.out.println(p.getName()); });
			 };
	
	}
		
	}


