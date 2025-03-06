/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public String url = "jdbc:mysql://localhost:3306/leiloes";
    public String user = "root";
    public String password = "dgc26275141";
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            conn = DriverManager.getConnection(url, user, password);
            st = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?,?, 'A Venda')");
            st.setString(1, produto.getNome());
            st.setString(2, Integer.toString(produto.getValor()));
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            status = st.executeUpdate();
            return status;
        }catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
        
        
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

