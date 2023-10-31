package py.edu.ucom.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucom.test.entities.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}