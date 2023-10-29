package py.edu.ucom.test.services;



import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.test.Config.IDAO;
import py.edu.ucom.test.entities.MetodoPago;
import py.edu.ucom.test.repositories.MetodoPagoRepository;


@ApplicationScoped
public class MetodoPagoService implements IDAO<MetodoPago,Integer> {
    @Inject
    private MetodoPagoRepository repository;

    @Override
    public MetodoPago obtener(Integer param) {
        // TODO Auto-generated method stub
        //MetodoPago m = new MetodoPago(1, "TEST", "TEST");
        return this.repository.findById(param).orElse(null);
    }

    @Override
    public MetodoPago agregar(MetodoPago param) {
        // TODO Auto-generated method stub
        return this.repository.save(param);
    }

    @Override
    public MetodoPago modificar(MetodoPago param) {
        // TODO Auto-generated method stub
        return this.repository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        // TODO Auto-generated method stub

        this.repository.deleteById(param);
    }

    @Override
    public List<MetodoPago> listar() {
        return this.repository.findAll();
    }

}