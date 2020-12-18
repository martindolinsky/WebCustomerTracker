package sk.itsovy.dolinsky.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.itsovy.dolinsky.spring.entity.Customer;

import java.util.List;

/**
 * @author Martin Dolinsky
 */
@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName");

		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;

	}

	@Override
	public void deleteCustomer(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}
}
