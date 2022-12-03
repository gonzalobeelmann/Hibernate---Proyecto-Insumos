package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import datos.Pedido;

public class PedidoABM {

	PedidoDao dao = new PedidoDao();
	
	public Pedido traerPedido(int idPedido) {
		return dao.traerPedido(idPedido);
	}
	
	public List<Pedido> traerPedido(boolean esCritico) {
		return dao.traerPedido(esCritico);
	}
	
	public double calcularTotal(int idPedido) {
		return this.traerPedido(idPedido).calcularTotal();
	}
	
	public List<Pedido> traerPedido(LocalDate fechaDesde, LocalDate fechaHasta) {
		return dao.traerPedido(fechaDesde, fechaHasta);
	}
	
	public List<Pedido> traerPedido(String area) {
		return dao.traerPedido(area);
	}
	
}
