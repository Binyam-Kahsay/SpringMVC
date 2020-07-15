package com.benEmpire.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.benEmpire.springdemo.entity.Customer;

@Repository()
public class CustomerDAOImplement implements CustomerDAO {

	            // need to inject the session factory from the .xml file ---tahti lelo
	@Autowired
	private SessionFactory sessionFactory;
	  
	
	
	
	@Override
	public List<Customer> getCustomer() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = 
				     session.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customers = query.getResultList();

		return customers;

	}




	@Override
	public void saveCustomerOther(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		         // based on the <form:hidden/> we specified in cutomer-form.jsp it knows if it is
		               // new or previos customer to create new or update existring
		
	}




	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer theCustmer = session.get(Customer.class, theId);
		
		return theCustmer;
	}




	@Override
	public void DeleteCustomer(int theID) {

		Session session = sessionFactory.getCurrentSession();
		
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", theID);
		
		
		query.executeUpdate();
		
		
	}




	@Override
	public List<Customer> searchCustomers(String theName) {
		
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(theName!=null && theName.trim().length()>0) {
		
		query = session.createQuery("from Customer where firstName like:thisname or lastName like:thisname",Customer.class);
		
		   query.setParameter("thisname", "%"+theName+"%");
		   
		   
		}
		else {         // if the searched name is not present give the the whole list
			    query = session.createQuery("from Customer", Customer.class);
		   }
		
		List<Customer> listOfCustomer = query.getResultList();
		
		return listOfCustomer;
		}
     }

















