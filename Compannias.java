
package laboratorio;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class Compannias {
    DB BD;
    DBCollection coleccion;
    
    public Compannias() throws java.net.UnknownHostException{
        Mongo mongo = new Mongo("localhost", 27017);
        BD = mongo.getDB("Laboratorio");
        coleccion = BD.getCollection("CompaniaProductora");
        System.out.println("Conexion exitosa");
    }
    
    public boolean insertar(String nombre,int anno,String direccion){
        BasicDBObject document = new BasicDBObject();
        
        document.put("Nombre",nombre);
        document.put("Anno",anno);
        document.put("Direccion", direccion);
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
