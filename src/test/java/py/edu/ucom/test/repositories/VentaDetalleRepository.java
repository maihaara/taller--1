package py.edu.ucom.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucom.test.entities.VentaDetalle;
import py.edu.ucom.test.entities.VentaDetalle.crearVentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Integer> {
    VentaDetalle save(crearVentaDetalle ventaDet);
}