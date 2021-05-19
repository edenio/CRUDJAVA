package dao;

import java.sql.Connection;
import model.Produto;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    
    private Connection conn;
    private PreparedStatement stmt; 
    private Statement st; 
    private ResultSet rs;
    private ArrayList <Produto> lista = new ArrayList <Produto>();
    public ProdutoDAO(){
    
        conn = new ConnectionFactory().getConexao();
    
    }
    public void inserir(Produto produto){
        
        String sql = "INSERT INTO produto (descricao_produto, preco_produto) VALUES(?,?) ";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao_produto());
            stmt.setDouble(2, produto.getPreco_produto());
            stmt.execute();
            stmt.close();
        
        }catch (Exception erro){
        throw new RuntimeException ("Erro 2: "+erro);
        
        }
      }
     public void alterar (Produto produto){
        
        String sql = "UPDATE produto SET descricao_produto = ?, WHERE codigo_produto = ? ";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao_produto());
            stmt.setDouble(2, produto.getPreco_produto());
            stmt.setInt(3, produto.getCodigo_produto());
            stmt.execute();
            stmt.close();
            
        
        }catch (Exception erro){
        throw new RuntimeException ("Erro 3: "+erro);
        
        }
      }
     
      public void excluir(Produto produto){
        
        String sql = "DELETE FROM produto WHERE codigo_produto = "+valor;
        try{
            
            st = conn.createStatement();
            st.execute(sql);
            st.close();
            
        }catch (Exception erro){
        throw new RuntimeException ("Erro 4: "+erro);
        
        }
      }
      
      public ArrayList <Produto> listarTodos(){
      String sql = "SELECT * FROM produto";
      
      try{
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()){
            Produto produto = new Produto();
            produto.setCodigo_produto(rs.getInt("codigo_produto"));
            produto.setDescricao_produto(rs.getString("descricao_produto"));
            produto.setPreco_produto(rs.getDouble("preco_produto"));
            lista.add(produto);
        }
      
      }catch (Exception erro){
      throw new RuntimeException("Erro 5: "+erro);
      
      }
      return lista;
      
      
      }
      
         public ArrayList <Produto> listarTodosDescricao(String valor){
      String sql = "SELECT * FROM produto WHERE descricao_produto LIKE '% "+valor+"%' ";
      
      try{
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()){
            Produto produto = new Produto();
            produto.setCodigo_produto(rs.getInt("codigo_produto"));
            produto.setDescricao_produto(rs.getString("descricao_produto"));
            produto.setPreco_produto(rs.getDouble("preco_produto "));
            lista.add(produto);
        }
      
      }catch (Exception erro){
      throw new RuntimeException("Erro 6: "+erro);
      
      }
      return lista;
      
      
      }
               
}
