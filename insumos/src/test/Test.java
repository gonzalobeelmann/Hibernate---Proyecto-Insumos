package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import datos.ItemPedido;
import datos.Pedido;
import negocio.PedidoABM;

public class Test {

	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		PedidoABM pedidoAbm = new PedidoABM();
		
		System.out.println("----------- 1) Traer e imprimir el pedido 1 -----------\n");
		
		Pedido pedido1 = pedidoAbm.traerPedido(1);
		System.out.println(pedido1 + "\n");
		if(!pedido1.getItemPedidos().isEmpty()) {
			System.out.println("Items del pedido:\n");
			for(ItemPedido item: pedido1.getItemPedidos()) {
				System.out.println(item);
			}
		}
		
		System.out.println("\n----------- 2) Traer e imprimir todos los pedidos críticos -----------\n");
		
		List<Pedido> pedidosCriticos = new ArrayList<Pedido>();
		pedidosCriticos = pedidoAbm.traerPedido(true);
		
		for(Pedido p: pedidosCriticos) {
			System.out.println(p);
		}
		
		System.out.println("\n----------- 3) Calcular el total del pedido 1 -----------\n");
		
		System.out.println("Total: $" + pedido1.calcularTotal());
		
		System.out.println("\n----------- 4) Traer e imprimir todos los pedidos entre el 12/05/2021 y el 13/06/2021 ordenados por fecha de\r"
				+ "creación -----------\n");
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos = pedidoAbm.traerPedido(LocalDate.of(2021, 5, 12), LocalDate.of(2021, 6, 13));
		
		for(Pedido p: pedidos) {
			System.out.println(p);
			for(ItemPedido item: p.getItemPedidos()) {
				System.out.println(item + " --- Insumo: " + item.getInsumo().getNombre());
			}
			System.out.println("");
		}
		
		System.out.println("\n----------- 5) Traer e imprimir todos los pedidos del área 1 -----------\n");
		
		pedidos.clear();
		pedidos = pedidoAbm.traerPedido("area1");
		
		for(Pedido pedido: pedidos) {
			System.out.println(pedido);
			for(ItemPedido item: pedido.getItemPedidos()) {
				System.out.println(item + " --- Insumo: " + item.getInsumo().getNombre());
			}
			System.out.println("");
		}
		
		

	}

}
