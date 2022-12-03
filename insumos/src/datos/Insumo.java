package datos;

public class Insumo {

	private int idInsumo;
	private String nombre;
	private double precioUnitario;
	
	public Insumo() {
		super();
	}
	
	public Insumo(String nombre, double precioUnitario) {
		super();
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
	}
	
	public int getIdInsumo() {
		return idInsumo;
	}
	protected void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "Insumo [idInsumo=" + idInsumo + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
	
}
