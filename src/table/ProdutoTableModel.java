package table;

import model.Produto;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
        
public class ProdutoTableModel extends AbstractTableModel {
    
    public static final int COL_CODIGO_PRODUTO = 0;
    public static final int COL_DESCRICAO_PRODUTO = 1;
    public static final int COL_PRECO_PRODUTO = 2;
    public ArrayList<Produto> lista;
    public ProdutoTableModel(ArrayList<Produto>l){
    
    lista= new ArrayList<Produto>(l);
    
    }

    @Override
    public int getRowCount() {
        
        return lista.size();
       
    }

    @Override
    public int getColumnCount() {
        
        return 3;
       
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        
        Produto produto = lista.get(linhas);
        if(colunas == COL_CODIGO_PRODUTO) return produto.getCodigo_produto();
        if(colunas == COL_DESCRICAO_PRODUTO) return produto.getDescricao_produto();
        if(colunas == COL_PRECO_PRODUTO) return produto.getPreco_produto();
        return "";
       
    }
    
    @Override
    public String getColumnName(int colunas){
        
        if(colunas == COL_CODIGO_PRODUTO) return "Código";
        if(colunas == COL_DESCRICAO_PRODUTO) return "Descrição";
        if(colunas == COL_PRECO_PRODUTO) return "Preço";
        return "";    
    
    
    }
    
    
}
