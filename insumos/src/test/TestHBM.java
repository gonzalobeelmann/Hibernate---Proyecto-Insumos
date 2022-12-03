package test;

import java.util.logging.Level;
import org.hibernate.Session;
import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la Session
		session.beginTransaction();//Crea una nueva transacci�n
		session.close(); //Una vez finalizado se deber� cerrar la sesi�n con el m�todo
		System.out.println("OK");
	}
}
