package py.edu.ucom.Entities;



import java.util.HashMap;
import java.util.Map;

public class detalleDeCompras {
    private static int codigoUnico = 1;
    private int codigoDeCompra;
    private HashMap<String, Double> detalles;
    private double total;
    private Cliente clientes;

    public detalleDeCompras(Cliente cliente) {
        this.detalles = new HashMap<>();
        this.codigoDeCompra = codigoUnico;
        codigoUnico++;
        this.clientes = cliente;
    }

    public void agregarProductos(Productos producto, int cantidad) {
        double subtotal = producto.getPrecio() * cantidad;
        detalles.put(producto.getNombre(), subtotal);
    }

    public double getTotal() {
        this.total = 0.0;
        for (Map.Entry<String, Double> entrada : detalles.entrySet()) {
            double subtotal = entrada.getValue();
            total += subtotal;
        }
        return total;
    }

    public int getCodigo() {
        return codigoDeCompra;
    }

    public Cliente getCliente() {
        return clientes;
    }

    public HashMap<String, Double> getListado() {
        return detalles;
    }

}
