package com.ipsas.gi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.http.util.Args;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

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
		
@SpringBootApplication
public class EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		
		return Args ->{
			productRepository.save(new Product((Integer) null,"HtP",44));
			productRepository.save(new Product((Integer) null,"HP",448));
			productRepository.save(new Product((Integer) null,"HPYYY",445));
			productRepository.save(new Product((Integer) null,"HPDDD",44));
		};
	}

}
