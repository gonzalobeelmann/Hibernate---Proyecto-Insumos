package test;

import java.util.logging.Level;
import org.hibernate.Session;
import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la Session
		session.beginTransaction();//Crea una nueva transacción
		session.close(); //Una vez finalizado se deberá cerrar la sesión con el método
		System.out.println("OK");
	}
}
