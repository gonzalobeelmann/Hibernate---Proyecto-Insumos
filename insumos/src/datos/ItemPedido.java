package datos;

public class ItemPedido {

	private int idItemPedido;
	private Insumo insumo;
	private Pedido pedido;
	private int cantidad;
	
	public ItemPedido() {
		super();
	}
	
	public ItemPedido(Insumo insumo, Pedido pedido, int cantidad) {
		super();
		this.insumo = insumo;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	protected void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", cantidad=" + cantidad + "]";
	}
	
	public double calcularSubTotal() {
		return this.getInsumo().getPrecioUnitario() * ((double)this.getCantidad());
	}
	
}
