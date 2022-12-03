package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemPedido;
import datos.Pedido;
	
public class PedidoDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}	
	
	public Pedido traerPedido(int idPedido) throws HibernateException {
		Pedido pedido = null;
		try {
			this.iniciaOperacion();
			pedido = session.get(Pedido.class, idPedido);
			Hibernate.initialize(pedido.getItemPedidos());
			for(ItemPedido item: pedido.getItemPedidos()) {
				Hibernate.initialize(item.getInsumo());
			}
		} finally {
			session.close();
		}
		return pedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(boolean esCritico) throws HibernateException {
		List<Pedido> pedidos = null;
		try {
			this.iniciaOperacion();
			String query = "from PedidoMensual order by idPedido";
			if(esCritico) query = "from PedidoCritico order by idPedido";
			pedidos = session.createQuery(query).list();
			// TAL VEZ LOS TEST PIDAN SU LISTA DE ITEMS. EN ESE CASO AGREGAR INITIALIZE 
		} finally {
			session.close();
		}
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Pedido> pedidos = null;
		try {
			this.iniciaOperacion();
			// SI EL TEST PIDE TRAER ITEMS, AGREGAR HIBERNATE INITIALIZE EN ESTE MÉTODO
			String query = "from Pedido as p where p.fechaCreacion between '" + fechaDesde + "' and '" + fechaHasta + "' order by p.fechaCreacion";
			pedidos = session.createQuery(query).list();
			for(Pedido p: pedidos) {
				Hibernate.initialize(p.getItemPedidos());
				for(ItemPedido item: p.getItemPedidos()) {
					Hibernate.initialize(item.getInsumo());
					Hibernate.initialize(item.getPedido());
				}
			}
		} finally {
			session.close();
		}
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> traerPedido(String area) throws HibernateException {
		List<Pedido> pedidos = null;
		try {
			this.iniciaOperacion();
			String query = "from Pedido where area = '" + area + "' order by idPedido asc";
			pedidos = session.createQuery(query).list();
			for(Pedido pedido: pedidos) {
				Hibernate.initialize(pedido.getItemPedidos());
				for(ItemPedido item: pedido.getItemPedidos()) {
					Hibernate.initialize(item.getInsumo());
					Hibernate.initialize(item.getPedido());
				}
			}
		} finally {
			session.close();
		}
		return pedidos;
	}
	
}
