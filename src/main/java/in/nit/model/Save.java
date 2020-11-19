package in.nit.model;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save {
	
	public static void main(String[] args) {
		//Save.insert();
		//Save.get();
		//Save.Updated();
		Save.delete();
	}
	public static void insert() {
		try {
			
			Configuration cfg = new Configuration();
			
			cfg.configure();
			SessionFactory sf= cfg.buildSessionFactory();
			Session ses= sf.openSession();
			Transaction tx=ses.beginTransaction();
			
			Customer cob= new Customer();
			cob.setCustId(103);
			cob.setCustName("vijay");
			cob.setCustAddr("sakinaka");
			ses.save(cob);
			
			tx.commit();
			ses.close();
		
		} catch (Exception e) {
        e.printStackTrace();

		}
}
	public static void get() {
		try {
Configuration cfg = new Configuration();
			
			cfg.configure();
			SessionFactory sf= cfg.buildSessionFactory();
			Session ses= sf.openSession();
			
			Customer cob= new Customer();
			cob=(Customer)ses.get(Customer.class,102);
			System.out.println(cob.getCustAddr());
			Transaction tx=ses.beginTransaction();
			tx.commit();
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Updated() {
		try {
Configuration cfg = new Configuration();
			
			cfg.configure();
			SessionFactory sf= cfg.buildSessionFactory();
			Session ses= sf.openSession();
			
			Customer cob= new Customer();
			cob.setCustId(102);
			cob.setCustName("Xyz");
			cob.setCustAddr("mira road");
			ses.update(cob);
			System.out.println(cob.getCustName());
			
			Transaction tx=ses.beginTransaction();
			tx.commit();
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete() {
		try {
Configuration cfg = new Configuration();
			
			cfg.configure();
			SessionFactory sf= cfg.buildSessionFactory();
			Session ses= sf.openSession();
			
			Customer cob= new Customer();
			cob.setCustId(102);
			ses.delete(cob);
			System.out.println(cob.getCustName());
			
			Transaction tx=ses.beginTransaction();
			tx.commit();
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}