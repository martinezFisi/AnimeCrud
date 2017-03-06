
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDb {
    
    private final String URL = "jdbc:mysql://localhost:3306/animes";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    //Método que obtiene una conexión
    public Connection getConnection() throws SQLException{
        Connection cn = null;
        
        try{
            //Levanta el driver
            Class.forName(DRIVER).newInstance();
            //Obtiene una conexión
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            
        }catch(ClassNotFoundException 
                | IllegalAccessException 
                | InstantiationException e){
            throw new SQLException(e.getMessage());
        }
        
        return cn;
    }
    
}
