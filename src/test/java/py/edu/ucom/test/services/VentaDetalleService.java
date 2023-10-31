package py.edu.ucom.test.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.test.Config.IDAO;
import py.edu.ucom.test.entities.Producto;
import py.edu.ucom.test.entities.Venta;
import py.edu.ucom.test.entities.VentaDetalle;
import py.edu.ucom.test.repositories.VentaDetalleRepository;
import java.util.List;




@ApplicationScoped
public class VentaDetalleService implements IDAO<VentaDetalle, Integer> {
    @Inject
    private VentaDetalleRepository repository;

    public VentaDetalle obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public VentaDetalle agregar(VentaDetalle ventaDetalle) {
        return repository.save(ventaDetalle);
    }

    public VentaDetalle modificar(VentaDetalle ventaDetalle) {
        return repository.save(ventaDetalle);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public List<VentaDetalle> listar() {
        return repository.findAll();
    }

    public VentaDetalle crearVentaDetalle(Venta venta, Producto producto, Integer cantidad) {
        int subtotal = producto.getPrecioUnitario() * cantidad;
        VentaDetalle ventaDet = new VentaDetalle(venta, producto, cantidad, subtotal);
        return repository.save(ventaDet);
    }
}
