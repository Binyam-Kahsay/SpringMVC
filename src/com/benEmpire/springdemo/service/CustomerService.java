package com.benEmpire.springdemo.service;

import java.util.List;

import com.benEmpire.springdemo.entity.Customer;

public interface CustomerService {

	
	       public List<Customer> getCustomer();

		public void saveCustomer(Customer theCustomer);

		public Customer getCustomer(int theId);

		public void DeleteCustomer(int theID);

		public List<Customer> searchCustomers(String theName);
	     
}
