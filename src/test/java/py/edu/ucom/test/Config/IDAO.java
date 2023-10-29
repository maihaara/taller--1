package py.edu.ucom.test.Config;

import java.util.List;

public interface IDAO<T,I> {
    T obtener (I param);
    T agregar(T param);
    T modificar(T param);
    void eliminar(I param);
    List<T> listar();
}
