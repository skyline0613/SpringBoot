package com.brancoder.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.demo.model.Customer;

@RestController
public class CustomerController {
	//透過 @RequestMapping 指定從/會被對應到此hello()方法
  @RequestMapping("/")
  public String hello(){
      return "It's my spring";
  }
  
  @RequestMapping("/customer")
  public Customer getCustomer(@RequestParam(value="name", defaultValue="World") String name) {
	  Customer customer = new Customer();
	  customer.setId("A123456789");
	  customer.setLastName("Lin");
	  customer.setFirstName("Brandon");
	  customer.setEmail("xyz@gmail.com");
      return customer;
  }  

}
