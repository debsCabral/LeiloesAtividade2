
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public String url = "jdbc:mysql://localhost:3306/leiloes";
    public String user = "root";
    public String password = "dgc26275141";
    
    public boolean conectar(){
        try{
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizazda com sucesso");
            return true;
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    
    public Connection getConexao(){
        return conn;
    }
    
    
    public void desconectar(){
        try {
            conn.close();
        }catch (SQLException ex){
            
        }
    }
    
}
