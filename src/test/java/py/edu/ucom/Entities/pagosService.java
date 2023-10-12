package py.edu.ucom.Entities;

import py.edu.ucom.Entities.detalleDeCompras;
import py.edu.ucom.Entities.Empleados;
import py.edu.ucom.Entities.Pagos;
import py.edu.ucom.Entities.Cliente;
import py.edu.ucom.Utils.datasource;
import py.edu.ucom.Entities.Productos;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class pagosService {

    @Inject
    private datasource ds;

    public Pagos generarPago(String documentoCliente, String docuEmpleado, int codProducto, int cantidad) {
        Cliente cliente = ds.buscarCliente(documentoCliente);
        Empleados empleado = ds.buscarEmpleado(docuEmpleado);
        Productos producto = ds.buscarProducto(codProducto);
    
        detalleDeCompras detalle = new detalleDeCompras(cliente);
        detalle.agregarProductos(producto, cantidad);
    
        Pagos pago = new Pagos(cliente, detalle, empleado);
    
        ds.guardarPagos(pago);
    
        return pago;
    }

    public Pagos generarPago(String docCliente, String docEmpleado, String codProducto, String cantidad) {
        return null;
    }

}