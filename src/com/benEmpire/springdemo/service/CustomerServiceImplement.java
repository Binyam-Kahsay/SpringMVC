package com.benEmpire.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benEmpire.springdemo.dao.CustomerDAO;
import com.benEmpire.springdemo.entity.Customer;



@Service
public class CustomerServiceImplement implements CustomerService {

	
	@Autowired
	private CustomerDAO theCustomerDao;
	
	@Transactional
	@Override
	public List<Customer> getCustomer() {
		
		return theCustomerDao.getCustomer();
	}

	
	 @Transactional
	 @Override
	 public void saveCustomer(Customer theCustomer) {
		
		theCustomerDao.saveCustomerOther(theCustomer);
	}


	@Transactional  
	@Override
	public Customer getCustomer(int theId) {

          return  theCustomerDao.getCustomer(theId); 
	}


	@Transactional
	@Override
	public void DeleteCustomer(int theID) {
		
		 theCustomerDao.DeleteCustomer(theID);
	}


	@Transactional
	@Override
	public List<Customer> searchCustomers(String theName) {
		
		List<Customer> theserched = theCustomerDao.searchCustomers(theName);
		
		return theserched;
	}

	
	
	
	
}
