package datos;

import java.time.LocalDate;

public class PedidoMensual extends Pedido {

	private LocalDate fechaEntrega;

	public PedidoMensual() {
		super();
	}

	public PedidoMensual(String area, LocalDate fechaCreacion, boolean abierto, LocalDate fechaEntrega) {
		super(area, fechaCreacion, abierto);
		this.fechaEntrega = fechaEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "PedidoMensual [idPedido=" + idPedido + ", area=" + area + ", fechaCreacion=" + fechaCreacion
				+ ", abierto=" + abierto + ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
}
