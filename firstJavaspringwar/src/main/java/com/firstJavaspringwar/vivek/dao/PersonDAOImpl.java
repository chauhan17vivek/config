package com.firstJavaspringwar.vivek.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firstJavaspringwar.vivek.model.Customer;
import com.firstJavaspringwar.vivek.model.Person;
import com.firstJavaspringwar.vivek.model.Txn;


@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
    @Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
        System.out.println("Person>>daoimpl"+p);
		Session session = this.sessionFactory.getCurrentSession();
		
		Txn txn = new Txn();
		txn.setDate(new Date());
		txn.setTotal(100);
		
		Customer cust = new Customer();
		cust.setAddress("San Jose, USA");
		cust.setEmail("pankaj@yahoo.com");
		cust.setName("Pankaj Kr");
		cust.setTxn(txn);
		
		
		// save the instructor
		//
		// Note: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + cust);
		session.save(cust);					
		
		// commit transaction
		
		
		
		
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person loadPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		long theId = 1;
		Txn tempInstructorDetail = 
				session.get(Txn.class, new Long(theId));
		
		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
					
		// print  the associated instructor
		System.out.println("the associated instructor: " + 
							tempInstructorDetail.getCustomer());
		Person p = (Person) session.get(Person.class, new Integer(id));
		
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}