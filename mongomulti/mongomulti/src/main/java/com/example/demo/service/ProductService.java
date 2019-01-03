package com.example.demo.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;


@Service
public class ProductService 
{
   @Autowired
   @Qualifier("primaryMongoTemplate")
   private MongoTemplate template1;
   
   @Autowired
   @Qualifier("secondaryMongoTemplate")
   private MongoTemplate template2;
   
   
   public List<Product>  findProducts1()
   {
	   System.out.println("find Products from e-store ");
	   
	   List<Product> result = template1.find(query(where("price").gt(15)), Product.class);
	   
	   return result;
	  
   }
   
   
   public List<Product>  findProducts2()
   {
	   System.out.println("find Products from second-store ");
	   
	   List<Product> result = template2.find(query(where("price").lt(18)), Product.class);
			   
	   
	   return result;
	   
   }
   
   
  
  
  
}
