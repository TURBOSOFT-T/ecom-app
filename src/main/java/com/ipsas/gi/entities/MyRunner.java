package com.ipsas.gi.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

// private static final Logger logger = LoggerFactory.logger(MyRunner.class);

@Autowired
private ProductRepository productRepository;

@Override
public void run(String... args) throws Exception {
    productRepository.deleteAll();
    productRepository.save(new Product( (Integer)null,"HtP",44));
	  productRepository.save(new Product((Integer) null,"HP",448));
	  productRepository.save(new Product((Integer)null,"HPYYY",445)); 
	  productRepository.save(new Product((Integer)null,"HPDDD",44));

	  productRepository.findAll().forEach(p->{
			
			 System.out.println(p.getName()); });
}
}
