package py.edu.ucom.Entities;

import java.util.HashMap;
import java.util.Map.Entry;

public class detalleDeCompras {
    private static int codigoUnico = 1;
    private int codigoCompra;
    private HashMap<String, Double> detalles;
    private double total;
    private Cliente cliente;

    public detalleDeCompras(Cliente cliente) {
        this.detalles = new HashMap<>();
        this.codigoCompra = codigoUnico;
        codigoUnico++;
        this.cliente = cliente;
    }

    public void agregarProductos(Productos producto, int cantidad) {
        double subtotal = producto.getPrecio() * cantidad;
        detalles.put(producto.getNombre(), subtotal);
    }

    public double getTotal() {
        this.total = 0.0;
        for (Entry<String, Double> entrada : detalles.entrySet()) {
            entrada.getValue();
            total += subtotal;
        }
        return total;
    }

    private double subtotal() {
        return 0;
    }

    public int getCodigo() {
        return codigoCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HashMap<String, Double> getListado() {
        return detalles;
    }

}
