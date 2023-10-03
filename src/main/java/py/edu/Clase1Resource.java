package py.edu;

import java.util.ArrayList;
import java.util.List;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.maihaara.entities.Alumno;



@Path("/clase1")
public class Clase1Resource {
      @GET
      public Double random() {
            return Math.random();

       }

      /**
       * @return
       */
      @GET
      @Path("obtener-alumno")
      @Consumes(MediaType.APPLICATION_JSON)
      public List<Alumno> obtenerAlumno() {
             List<Alumno> listaAlumnos = new ArrayList<>();
             Alumno data = new Alumno();
             data.setApellido("Netepczuk");;
             data.setNombre("Maihara");
             Alumno data2 = new Alumno();
             data2.setApellido("Netepczuk");;
             data2.setNombre("Maihara");

             listaAlumnos.add(data);
             listaAlumnos.add(data2);
             return listaAlumnos;
      }
}

 

