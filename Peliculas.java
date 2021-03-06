package laboratorio;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import javax.accessibility.AccessibleContext;

public class Peliculas {
    DB BD;
    DBCollection coleccion;
  
    
    public Peliculas() throws java.net.UnknownHostException{
        Mongo mongo = new Mongo("localhost", 27017);
        BD = mongo.getDB("Laboratorio");
        coleccion = BD.getCollection("Peliculas");
        System.out.println("Conexion exitosa");
    }
    
    public boolean insertar(String nombre, String director, String franquicia, String genero, String productor, String pais, int anno, int duracion, String actores){
        BasicDBObject document = new BasicDBObject();
        
        document.put("Nombre",nombre);
        document.put("Director",director);
        document.put("Franquicia",franquicia);
        document.put("Genero",genero);
        document.put("Productor",productor);
        document.put("Pais",pais);
        document.put("Anno",anno);
        document.put("Duracion",duracion);
        document.put("Actores",actores);
        coleccion.insert(document);
        return true;
    }
    
    public boolean modificar(String nombre, String valor, String nuevo){
        BasicDBObject Ndocument = new BasicDBObject();
        BasicDBObject buscar = new BasicDBObject().append("Nombre",nombre);
        Ndocument.put(valor,nuevo);    
        coleccion.update(buscar,Ndocument);
        return true;
    }
    
    public boolean eliminar(String nombre){
        BasicDBObject document = new BasicDBObject();
        document.put("Nombre", nombre);
        coleccion.remove(document);
        return true;
    }
}
