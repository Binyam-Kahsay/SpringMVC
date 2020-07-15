package com.benEmpire.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.benEmpire.springdemo.entity.Customer;
import com.benEmpire.springdemo.service.CustomerService;






@Controller
@RequestMapping("/customer")
public class CustomerController {

      @Autowired
      private CustomerService theCustomerservice;
	
	
	        
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// delegatig the customerservice
		List<Customer> theCustomers = theCustomerservice.getCustomer();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "customer-list";
	}
	
	
	@GetMapping("/ShowAddCustomerForm")
	public String ShowAddCustomerForm(Model themodel) {
		
		Customer customer = new Customer();
		
		
		             // for binding the form with the class data
		themodel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		theCustomerservice.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/updateFormAdd")
	public String updateFormAdd(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer =theCustomerservice.getCustomer(theId);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	
	
//	@GetMapping("/deleteCustomerForm")
//	public String deleteCustomerForm(@RequestParam("customerId") int theID) {
//		
//		
//		 theCustomerservice.DeleteCustomer(theID);
//		
//		
//		
//		return "redirect:/customer/list";
//	}
//	
	
	
	@GetMapping("/deleteCustomerForm")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		theCustomerservice.DeleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/SearchCustomer")              
	public String SearchCustomer(@RequestParam("searchName") String theName, Model theModel) {
		
		
		List<Customer> theSearched = theCustomerservice.searchCustomers(theName);
		
		theModel.addAttribute("customers", theSearched);
		
		return "customer-list";
	}
	
	
	
	
	
	
}














//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//	
//	// inject DAO in to contrller
//	
//	
//	@Autowired                     // spring will scan component which implements this interface
//	private CustomerDAO theCustomerDAO;
//	
//	@RequestMapping("/list")
//	public String listCustomers(Model model) {
//		
//		
//		List<Customer> theCustmor = theCustomerDAO.getCustomer();
//		
//		model.addAttribute("customers",theCustmor);
//		
//		
//		return "customer-list";
//	}
//
//}
