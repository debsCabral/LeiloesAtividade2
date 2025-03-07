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
        try{
            conn = DriverManager.getConnection(url, user, password);
            st = conn.prepareStatement("SELECT * FROM produtos");
            rs = st.executeQuery();
          
            ArrayList<ProdutosDTO> listaProdutos = new ArrayList<>();
          
            while(rs.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
              
                listaProdutos.add(produto);
            }
            return listaProdutos;
        }catch (SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }  
    }
    
    
    public int venderProduto(ProdutosDTO produto){
        int status;
        try{
            conn = DriverManager.getConnection(url, user, password);
            st = conn.prepareStatement("UPDATE produtos SET status = 'Vendido' WHERE id = ?");
            st.setString(1, Integer.toString(produto.getId()));
            status = st.executeUpdate();
            return status;  
        }catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        try{
            conn = DriverManager.getConnection(url, user, password);
            st = conn.prepareStatement("SELECT * FROM produtos WHERE status LIKE 'Vendido'");
            rs = st.executeQuery();
            
            ArrayList<ProdutosDTO> listaProdutosVendidos = new ArrayList<>();
            
            while(rs.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
                
                listaProdutosVendidos.add(produto);
            }
            return listaProdutosVendidos;
        }catch (SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }     
    }
}

