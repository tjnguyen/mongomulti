package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ErrorInfo;
import com.example.demo.domain.Product;
import com.example.demo.domain.ProductResponse;
import com.example.demo.exception.DataAccessException;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value="/demo")
public class ProductController 
{
   
   @Autowired
   private ProductService prodService;
   
   
  
   
   
   @GetMapping(value="/Hello/{name}", produces = "application/json")
   public String helloText(@PathVariable("name") String name)
   {
	   System.out.println("calling helloText");
	   ProductResponse resp = new ProductResponse();
	   
	   resp.setMessage("How are you " + name);
	   return "hello";
   }
   
  
   
   @RequestMapping(method=RequestMethod.GET, value="/getAllProduct1")
    public List<Product> getProducts () throws DataAccessException
    {
	   List<Product> products  = null;
	   try
	   {
	      System.out.println("retrieve all products1");
	      
	      products = prodService.findProducts1();
	      
	      for (Product p:products)
	      {
	    	  System.out.println(p.getName() + " " + p.getDescription() + " " + p.getPrice());
	      }
	      
	   }
	   catch(Exception ex)
	   {
		   throw new DataAccessException("Error retriving products from database");
	   }
    	
    	
    	return products;
    }  
   
   
   @RequestMapping(method=RequestMethod.GET, value="/getAllProduct2")
   public List<Product> getProducts2 () throws DataAccessException
   {
	   List<Product> products  = null;
	   try
	   {
	      System.out.println("retrieve all products2");
	      
	      products = prodService.findProducts2();
	      
	      for (Product p:products)
	      {
	    	  System.out.println(p.getName() + " " + p.getDescription() + " " + p.getPrice());
	      }
	      
	   }
	   catch(Exception ex)
	   {
		   throw new DataAccessException("Error retriving products from database");
	   }
   	
   	
   	return products;
   }  
   
   
   
   @ExceptionHandler(DataAccessException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ResponseBody ErrorInfo
   handleProductException (DataAccessException ex, HttpServletRequest req)
   {
	   System.out.println("calling handleProductException");
	   req.setAttribute("javax.servlet.error.status_code",
						HttpStatus.INTERNAL_SERVER_ERROR.value()); 
	   req.setAttribute("exceptionMessage", ex.getMessage());
	   
	   ErrorInfo errorInfo = new ErrorInfo("/displayerror", ex);
	   
	   return errorInfo;
	   

   }
   
	   
}
