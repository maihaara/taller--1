package py.edu.ucom.test.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import py.edu.ucom.test.entities.Venta;

public interface VentaRepository extends JpaRepository<Venta,Integer> {

}
