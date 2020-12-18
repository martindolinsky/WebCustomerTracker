package sk.itsovy.dolinsky.spring.service;

import sk.itsovy.dolinsky.spring.entity.Customer;

import java.util.List;

/**
 * @author Martin Dolinsky
 */
public interface CustomerService {

	public List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
}
