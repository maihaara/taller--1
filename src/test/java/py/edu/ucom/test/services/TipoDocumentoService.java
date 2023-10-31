package py.edu.ucom.test.services;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.test.Config.IDAO;
import py.edu.ucom.test.entities.TipoDocumento;
import py.edu.ucom.test.repositories.TipoDocumentoRepository;



@ApplicationScoped
public class TipoDocumentoService implements IDAO<TipoDocumento, Integer> {

    @Inject
    private TipoDocumentoRepository repository;

    @Override
    public TipoDocumento obtener(Integer param) {
        return this.repository.findById(param).orElse(null);
    }

    @Override
    public TipoDocumento agregar(TipoDocumento param) {
        return this.repository.save(param);
    }

    @Override
    public TipoDocumento modificar(TipoDocumento param) {
        return this.repository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        this.repository.deleteById(param);
    }

    @Override
    public List<TipoDocumento> listar() {
        return this.repository.findAll();
    }

    public TipoDocumento obtener(TipoDocumento tipoDocumentoId) {
        return null;
    }

}