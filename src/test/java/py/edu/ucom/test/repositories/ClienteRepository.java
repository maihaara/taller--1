package py.edu.ucom.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucom.test.entities.cliente;

public interface ClienteRepository extends JpaRepository<cliente,Integer> {

}
