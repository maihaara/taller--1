package py.edu.ucom.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.entitiess.Libros;
import py.edu.ucom.entitiess.Usuarios;


@ApplicationScoped
public class DataSourceJSON {
    public String SRC_USUARIOS = "C:\\Users\\mahia\\Desktop\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\usuarios.json";
    public String SRC = "C:\\Users\\mahia\\Desktop\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\libros.json";

    public void guardarLibro(Libros libro) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Libros> lista = obtenerLibros();
            lista.add(libro);
            mapper.writeValue(new File(this.SRC), lista);
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }  


      
    public List<Libros> obtenerLibros() {
        ObjectMapper mapper = new ObjectMapper();
        List<Libros> libros = new ArrayList<>();
        try {
            libros = mapper.readValue(
                new File(this.SRC),
                new TypeReference<List<Libros>>() {
                });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return libros;
    }




    public void guardarUsuarios(Usuarios usuario) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Usuarios> lista = obtenerUsuarios();
            usuario.setLibrosPrestados(new ArrayList<>());
            lista.add(usuario);
            mapper.writeValue(new File(this.SRC_USUARIOS), lista);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }



    public List<Usuarios> obtenerUsuarios(){

        ObjectMapper mapper = new ObjectMapper();
        List<Usuarios> data = new ArrayList<>();
        try {
            data = mapper.readValue(
            new File(this.SRC_USUARIOS),
            new TypeReference<List<Usuarios>>() {
            });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        return data;
    }

       
    public Libros buscarLibros(String isbn){
        Libros libro = null;
        List<Libros> data = obtenerLibros();

        for (Libros item : data) {
        if (item.getISBN().equals(isbn)){
            libro = item;
        }
         return item;

        }
    }

    public Usuarios buscarUsuario(String documento){
        Usuarios usuario =  null;
        List<Usuarios> data = obtenerUsuarios();

            for (Usuarios item : data) {


                if ( item.getDocumento())equals(documento);
                    usuario = item;
                }
                    
        return usuario;

    }

    public void actualizarLibro(Libros param) {
        List<Libros> data = obtenerLibros();
 
        for (Libros item : data) {
            if (item.getISBN().equals(param.getISBN())){
            if(param.getPrestados()  ){
                item.setPrestado(param.getPrestado());
            }
            if(param.getPrestados()   && !param.getTitulo() .isEmpty()){
                item.setTitulo(param.getTitulo());
            }
            if(param.getPrestados()   && !param.getAutor() .isEmpty()){
                item.setAutor(param.getAutor());
            }

            }
            }
            for (Libros item : data){
                System.out.println(item.getISBN()+ "---"+ item.getPrestado());
            }
            try  {
                ObjectMapper mapper = new ObjectMapper();
                ObjectMapper mappe;
                mappe.writeValue(new File(this.SRC_USUARIOS), mappe );

            } catch (Exception e) {
        }
    }
       private void a() {
    }



    public void actualizarUsuario(Usuarios param){
        List<Usuarios> data = obtenerUsuarios();
        for (Usuarios item : data) {
        if (item.getDocumentos().equals(param.getDocumento())) {

            item.setNombre(param.getDocumento());
            item.setLibrosPrestados(param.getLibrosPrestados());
            break;
        }
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(this.SRC_USUARIOS), data);
            } catch (Exception e) {
        }

    }



    public Libros buscarLibro(String param) {
        return null;
    }

}



