package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Topico;

/**
 *
 * @author Andy
 */
public class TopicoDAO {
    
    private Connection conexao;
    
    public TopicoDAO() {
        conexao = DAO.getConnection();
    }
    
    public List<Topico> listaDeTopicos(){
        String sql = "SELECT * FROM topico";
        List<Topico> lista = new ArrayList<Topico>();
        PreparedStatement pstatement;
        ResultSet resultado;
        Topico topico;
        
        try {
            pstatement = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            resultado = pstatement.executeQuery();
            
            while (resultado.next()) {
                topico = new Topico();
                
                String nome = resultado.getString("NOMETOPICO");
                int identificador = resultado.getInt("IDTOPICO");
                
                topico.setId(identificador);
                topico.setNome(nome);
                
                lista.add(topico);
            }
            
        } catch (SQLException excecao) {
            System.err.println("Excecao : " + excecao.getMessage());
        }
        return lista;
    }
    
}