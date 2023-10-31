package abc;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import abc.entity.Address;
import abc.entity.Student;

public class App {
	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Address address = new Address();
		
		address.setAddressId(1);
		address.setCity("A");
		address.setStreet("B");
		
		// Reading Imaage
		FileInputStream fis = new FileInputStream("");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		
		
		session.save(address);
		
		Student st = new Student(1, "A", "B");
		
		session.save(st);
		
		transaction.commit();
		
		st = session.get(Student.class, 1); System.out.println(st);
		address = session.get(Address.class, 1); System.out.println(address);
		
		session.close();
	}
}