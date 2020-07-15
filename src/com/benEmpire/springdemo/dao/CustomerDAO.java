package com.benEmpire.springdemo.dao;

import java.util.List;

import com.benEmpire.springdemo.entity.Customer;

public interface CustomerDAO {

	
	    public List<Customer> getCustomer();

		public void saveCustomerOther(Customer theCustomer);

		public Customer getCustomer(int theId);

		public void DeleteCustomer(int theID);

		public List<Customer> searchCustomers(String theName);
}
