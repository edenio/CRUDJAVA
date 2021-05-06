
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConexao(){
    try {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mercado","root","44ed2817")
    
    } catch (SQLException erro){
    throw new RuntimeException("Erro 1:" + erro);
    
    }
    }
    
}
