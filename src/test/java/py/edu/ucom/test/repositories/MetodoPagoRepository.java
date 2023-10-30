package py.edu.ucom.test.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.edu.ucom.test.entities.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago,Integer> {


    public List<MetodoPago> findByCodigo(String codigo);

    @Query("SELECT SUM(m.metodoPagoId) FROM MetodoPago m")
    Long sumId();
}
