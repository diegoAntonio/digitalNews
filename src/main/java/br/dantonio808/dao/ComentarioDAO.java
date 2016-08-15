package br.dantonio808.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.dantonio808.model.Comentario;

/**
 *
 * @author Andy
 */
public class ComentarioDAO {

    private final Connection conexao;

    public ComentarioDAO() {
        conexao = DAO.getConnection();
    }

    public void inserirComentario(Comentario comentario) throws SQLException {
        StringBuilder sql;
        PreparedStatement pstatement;

        sql = new StringBuilder("INSERT INTO comentario ");
        sql.append("(cod_usuario, cod_noticia, comentario, dataDePublicacao) ");
        sql.append("VALUES (?,?,?,?)");

        try {
            pstatement = conexao.prepareStatement(sql.toString());

            int codigoUsuario = comentario.getIdUsuario();
            int codigoNoticia = comentario.getIdNoticia();
            String conteudo = comentario.getConteudo();
            Date hoje = new Date();
            
            pstatement.setInt(1, codigoUsuario);
            pstatement.setInt(2, codigoNoticia);
            pstatement.setString(3, conteudo);
            pstatement.setDate(4, new java.sql.Date(hoje.getTime()));

            pstatement.executeUpdate();

        } catch (SQLException excecao) {
            System.out.println("inserirComentario");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());            
            throw excecao;
        }
        
    }

    public List<Comentario> listarComentarios(int identificadorDaNoticia) {
        StringBuilder sql;
        PreparedStatement pstatement;
        List<Comentario> listaDeComentarios = new ArrayList<Comentario>();
        Comentario comentario;
        
        sql = new StringBuilder("SELECT * FROM comentario WHERE ");
        sql.append("cod_noticia = ? ORDER BY idcomentario DESC");

        try {
            pstatement = conexao.prepareStatement(sql.toString());

            pstatement.setInt(1, identificadorDaNoticia);

            ResultSet resultado = pstatement.executeQuery();

            //int i = 0;
            
            while (resultado.next()) {
                comentario = new Comentario();
                

                int identificador = resultado.getInt("IDCOMENTARIO");
                int identificadorNoticia = resultado.getInt("COD_NOTICIA");
                int identificadorUsuario = resultado.getInt("COD_USUARIO");
                String conteudo = resultado.getString("COMENTARIO");
                Date data = new Date(resultado.getDate("DATADEPUBLICACAO").getTime());
                 
                comentario.setIdentificador(identificador);
                comentario.setIdUsuario(identificadorUsuario);
                comentario.setIdNoticia(identificadorNoticia);
                comentario.setConteudo(conteudo);
                comentario.setDataDePublicacao(data);
                
                listaDeComentarios.add(comentario);
            }

        } catch (SQLException excecao) {
            System.out.println("listarComentarios");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return listaDeComentarios;
    }

    public boolean excluirComentario(int identificador) {
        String sql = "DELETE FROM comentario WHERE idComentario = ?";
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, identificador);

            pstatement.executeUpdate();

        } catch (SQLException excecao) {
            System.out.println("excluirComentario");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
            return false;
        }
        return true;
    }
    
    public boolean excluirComentariosDaNoticia (int identificador) {
        String sql = "DELETE FROM comentario WHERE cod_noticia = ?";
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, identificador);

            pstatement.executeUpdate();

        } catch (SQLException excecao) {
            System.out.println("excluirComentariosDaNoticia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
            return false;
        }
        return true;        
    }

    public List<Comentario> listarTodosOsComentarios() {
        StringBuilder sql;
        PreparedStatement pstatement;
        List<Comentario> listaDeComentarios = new ArrayList<Comentario>();
        Comentario comentario;
        
        sql = new StringBuilder("SELECT * FROM comentario ORDER BY idcomentario DESC");
        
        try {
            pstatement = conexao.prepareStatement(sql.toString());
            
            ResultSet resultado = pstatement.executeQuery();

           // int i = 0;
            
            while (resultado.next()) {
                comentario = new Comentario();
                

                int identificador = resultado.getInt("IDCOMENTARIO");
                int identificadorNoticia = resultado.getInt("COD_NOTICIA");
                int identificadorUsuario = resultado.getInt("COD_USUARIO");
                String conteudo = resultado.getString("COMENTARIO");
                Date data = new Date(resultado.getDate("DATADEPUBLICACAO").getTime());
                 
                comentario.setIdentificador(identificador);
                comentario.setIdUsuario(identificadorUsuario);
                comentario.setIdNoticia(identificadorNoticia);
                comentario.setConteudo(conteudo);
                comentario.setDataDePublicacao(data);
                
                listaDeComentarios.add(comentario);
            }

        } catch (SQLException excecao) {
            System.out.println("listarTodosOsComentarios");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return listaDeComentarios;
    }
    
    public List<Comentario> listarTodosOsComentariosBloqueados() {
        List<Comentario> lista = null;
        
        return lista;
    }
    
}