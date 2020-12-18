package sk.itsovy.dolinsky.spring.dao;

import sk.itsovy.dolinsky.spring.entity.Customer;

import java.util.List;

/**
 * @author Martin Dolinsky
 */
public interface CustomerDAO {

	public List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
}
