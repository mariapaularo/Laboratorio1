package laboratorio;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

public class Peliculas {
    DB BD;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
  
    
    public Peliculas() throws java.net.UnknownHostException{
        Mongo mongo = new Mongo("localhost", 27017);
        BD = mongo.getDB("Laboratorio");
        coleccion = BD.getCollection("Peliculas");
        System.out.println("Conexion exitosa");
    }
    
    public boolean insertar(String nombre, String director, String franquicia, String genero, String productor, String pais, int anno, int duracion, String actores){
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
    
    public boolean modificar(String columna, String valor, String nuevo){
        document.put(columna,valor);
        BasicDBObject DocNuevo = new BasicDBObject();
        DocNuevo.put(columna,nuevo);
        coleccion.findAndModify(document,DocNuevo);
        return true;
    }
    
    public boolean eliminar(String valor){
        document.put("Nombre", valor);
        coleccion.remove(document);
        return true;
    }
}
