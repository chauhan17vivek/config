
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.firstJavaspringwar.vivek.configuration.PersistenceConfig;
import com.firstJavaspringwar.vivek.model.Person;

public class HibernateGetVsLoad {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext ctc= new AnnotationConfigApplicationContext(PersistenceConfig.class);
		
				
		SessionFactory sessionFactory=ctc.getBean(SessionFactory.class);
		
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Get Example
		Person emp = (Person) session.get(Person.class, 2);
		System.out.println("Employee get called");
		System.out.println("Employee ID= "+emp.getId());
		System.out.println("Employee Get Details:: "+emp+"\n");
		
		//load Example
		Person emp1 = (Person) session.load(Person.class, 1);
		System.out.println("Employee load called");
		System.out.println("Employee ID= "+emp1.getId());
		System.out.println("Employee load Details:: "+emp1+"\n");
		
		//Close resources
		tx.commit();
		sessionFactory.close();
	}
}