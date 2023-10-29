package py.edu.ucom.test.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucom.test.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}