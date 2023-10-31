package py.edu.ucom.test.services;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.test.Config.IDAO;
import py.edu.ucom.test.entities.Cliente;
import py.edu.ucom.test.entities.Producto;
import py.edu.ucom.test.services.ProductoService;
import py.edu.ucom.test.repositories.ProductoRepository;


@ApplicationScoped
public class ProductoService implements IDAO<Producto,Integer> {
    @Inject
    private ProductoRepository repository;

    @Override
    public Producto obtener(Integer param) {
        return this.repository.findById(param).orElse(null);
    }

    @Override
    public Producto agregar(Producto param) {
        return this.repository.save(param);
    }

    @Override
    public Producto modificar(Producto param) {
        return this.repository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        this.repository.deleteById(param);
    }

    @Override
    public List<Producto> listar() {
        return this.repository.findAll();
    }

    public void modificar(Cliente param) {
    }



    public void modificarStock(Integer cantidad, Producto producto) {
        int stockActual = producto.getStock();
    
        if (cantidad >= 0) {
            producto.setStock(stockActual + cantidad);
        } else {
            int nuevoStock = stockActual + cantidad;
            if (nuevoStock >= 0) {
                producto.setStock(nuevoStock);
            }
        }
    
        this.modificar(producto);
    }

    public void cambiarStock(Integer cantidad, Producto producto) {
    }

    public void sumarStock(Integer cantidad, Producto producto) {
    }

    public boolean restarStock(Integer cantidad, Producto producto) {
        return false;
    }
}

