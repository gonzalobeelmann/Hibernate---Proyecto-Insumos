package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

	protected int idPedido;
	protected String area;
	protected LocalDate fechaCreacion;
	protected boolean abierto;
	protected Set<ItemPedido> itemPedidos = new HashSet<ItemPedido>();
	
	public Pedido() {
		super();
	}
	public Pedido(String area, LocalDate fechaCreacion, boolean abierto) {
		super();
		this.area = area;
		this.fechaCreacion = fechaCreacion;
		this.abierto = abierto;
	}
	public int getIdPedido() {
		return idPedido;
	}
	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isAbierto() {
		return abierto;
	}
	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}
	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}
	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", area=" + area + ", fechaCreacion=" + fechaCreacion + ", abierto="
				+ abierto + "]";
	}
	
	public double calcularTotal() {
		double total = 0;
		for(ItemPedido itemPedido: this.getItemPedidos()) {
			total += itemPedido.calcularSubTotal();
		}
		return total;
	}
	
	
	
}
