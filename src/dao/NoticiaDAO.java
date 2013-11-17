package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Noticia;

/**
 *
 * @author Andy
 */
public class NoticiaDAO {

    private final Connection conexao;

    public NoticiaDAO() {
        conexao = DAO.getConnection();
    }

    public boolean inserir(Noticia noticia) {
        StringBuilder sql;

        sql = new StringBuilder("INSERT INTO noticia ");
        sql.append("(idNoticia,cod_Usuario,cod_Topico,texto,data_de_publicacao,titulo,avaliacao,bloqueada) ");
        sql.append("VALUES (?,?,?,?,?,?,?,?)");

        try {
            Date hoje = new Date();
            
            noticia.setDataDePublicacao(hoje);
            noticia.setAvaliacao(0);
            noticia.setBloqueio(false);

            PreparedStatement pstatement;

            pstatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pstatement.setInt(1, noticia.getIdentificador());
            pstatement.setInt(2, noticia.getCodigoUsuario());
            //pstatement.setInt(2, 2);
            pstatement.setInt(3, noticia.getCodigoTopico());
            pstatement.setString(4, noticia.getConteudo());
            pstatement.setDate(5, new java.sql.Date(noticia.getDataDePublicacao().getTime()));
            pstatement.setString(6, noticia.getTitulo());
            pstatement.setInt(7, noticia.getAvaliacao());
            pstatement.setBoolean(8, noticia.isBloqueio());

            pstatement.executeUpdate();

        } catch (SQLException excecao) {
            System.out.println("inserir");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
            return false;
        }
        return true;
    }

    public boolean deletarNoticia(int codigoNoticia) {
        String sql = "DELETE FROM noticia WHERE idNoticia = ?";
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, codigoNoticia);

            pstatement.executeUpdate();

            return true;

        } catch (SQLException excecao) {
            System.out.println("deletar");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
            return false;
        }
    }

    public List<Noticia> listarTodasAsNoticiasDoUsuario(int codigoUsuario) {
        String sql = "SELECT * FROM noticia WHERE cod_usuario = ?";
        List<Noticia> listaDeNoticias = new ArrayList<Noticia>();
        Noticia noticia;
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, codigoUsuario);

            ResultSet resultado = pstatement.executeQuery();

            while (resultado.next()) {
                noticia = new Noticia();

                int id = resultado.getInt("IDNOTICIA");
                int idUsuario = resultado.getInt("COD_USUARIO");
                int idTopico = resultado.getInt("COD_TOPICO");
                Date dataDePublicacao = resultado.getDate("DATA_DE_PUBLICACAO");
                String conteudo = resultado.getString("TEXTO");
                String titulo = resultado.getString("TITULO");
                int avaliacao = resultado.getInt("AVALIACAO");
                boolean estaBloqueada = resultado.getBoolean("BLOQUEADA");

                noticia.setIdentificador(id);
                noticia.setCodigoUsuario(idUsuario);
                noticia.setCodigoTopico(idTopico);
                noticia.setDataDePublicacao(dataDePublicacao);
                noticia.setConteudo(conteudo);
                noticia.setTitulo(titulo);
                noticia.setAvaliacao(avaliacao);
                noticia.setBloqueio(estaBloqueada);

                listaDeNoticias.add(noticia);

            }

        } catch (SQLException excecao) {
            System.out.println("listarTodasAsNoticiasDoUsuario");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return listaDeNoticias;
    }

    public List<Noticia> listarNoticiasBloqueadas() {
        String sql = "SELECT * FROM noticia WHERE BLOQUEADA = ?";
        List<Noticia> listaDeNoticias = new ArrayList<Noticia>();
        Noticia noticia;
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setBoolean(1, true);

            ResultSet resultado = pstatement.executeQuery();

            while (resultado.next()) {
                noticia = new Noticia();

                int id = resultado.getInt("IDNOTICIA");
                int idUsuario = resultado.getInt("COD_USUARIO");
                int idTopico = resultado.getInt("COD_TOPICO");
                Date dataDePublicacao = resultado.getDate("DATA_DE_PUBLICACAO");
                String conteudo = resultado.getString("TEXTO");
                String titulo = resultado.getString("TITULO");
                int avaliacao = resultado.getInt("AVALIACAO");
                boolean estaBloqueada = resultado.getBoolean("BLOQUEADA");

                noticia.setIdentificador(id);
                noticia.setCodigoUsuario(idUsuario);
                noticia.setCodigoTopico(idTopico);
                noticia.setDataDePublicacao(dataDePublicacao);
                noticia.setConteudo(conteudo);
                noticia.setTitulo(titulo);
                noticia.setAvaliacao(avaliacao);
                noticia.setBloqueio(estaBloqueada);

                listaDeNoticias.add(noticia);
            }

        } catch (SQLException excecao) {
            System.out.println("listarNoticiasBloqueadas");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return listaDeNoticias;
    }

    public List<Noticia> listarNoticiasMaisBemAvaliadas() {
        String sql = "SELECT * FROM noticia WHERE AVALIACAO <> ? AND AVALIACAO IS NOT NULL ORDER BY avaliacao DESC";
        List<Noticia> listaDeNoticias = new ArrayList<Noticia>();
        Noticia noticia;
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, 0);

            ResultSet resultado = pstatement.executeQuery();

            while (resultado.next()) {
                noticia = new Noticia();

                int id = resultado.getInt("IDNOTICIA");
                int idUsuario = resultado.getInt("COD_USUARIO");
                int idTopico = resultado.getInt("COD_TOPICO");
                Date dataDePublicacao = resultado.getDate("DATA_DE_PUBLICACAO");
                String conteudo = resultado.getString("TEXTO");
                String titulo = resultado.getString("TITULO");
                int avaliacao = resultado.getInt("AVALIACAO");
                boolean estaBloqueada = resultado.getBoolean("BLOQUEADA");

                noticia.setIdentificador(id);
                noticia.setCodigoUsuario(idUsuario);
                noticia.setCodigoTopico(idTopico);
                noticia.setDataDePublicacao(dataDePublicacao);
                noticia.setConteudo(conteudo);
                noticia.setTitulo(titulo);
                noticia.setAvaliacao(avaliacao);
                noticia.setBloqueio(estaBloqueada);

                listaDeNoticias.add(noticia);
            }

        } catch (SQLException excecao) {
            System.out.println("listarNoticiasMaisBemAvaliadas");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return listaDeNoticias;
    }

    public boolean desbloquearNoticia(int identificador) {
        String sql = "UPDATE noticia SET bloqueada = false WHERE idNoticia = ?";
        PreparedStatement pstatement;

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, identificador);

            pstatement.executeUpdate();

            return true;
        } catch (SQLException excecao) {
            System.out.println("desbloquearNoticia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return false;
    }

    public Noticia buscarNoticiaUsuarioLogado(int identificador) {
        Noticia noticia = null;
        PreparedStatement pstatement;
        ResultSet resultado;
        String sql = "SELECT * FROM noticia WHERE idnoticia = ?";

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, identificador);

            resultado = pstatement.executeQuery();

            while (resultado.next()) {
                int idnoticia = resultado.getInt("IDNOTICIA");
                int codigo_usuario = resultado.getInt("COD_USUARIO");
                int codigo_topico = resultado.getInt("COD_TOPICO");
                String conteudo = resultado.getString("TEXTO");
                long dataDoBancoMilisegundos = resultado.getDate("DATA_DE_PUBLICACAO").getTime();
                Date data_de_publicacao = new Date(dataDoBancoMilisegundos);
                String titulo = resultado.getString("TITULO");
                int quantidadeDeAvaliacoes = resultado.getInt("AVALIACAO");
                boolean bloqueada = resultado.getBoolean("BLOQUEADA");

                noticia = new Noticia();

                noticia.setIdentificador(idnoticia);
                noticia.setCodigoUsuario(codigo_usuario);
                noticia.setCodigoTopico(codigo_topico);
                noticia.setConteudo(conteudo);
                noticia.setDataDePublicacao(data_de_publicacao);
                noticia.setTitulo(titulo);
                noticia.setAvaliacao(quantidadeDeAvaliacoes);
                noticia.setBloqueio(bloqueada);
            }
        } catch (SQLException excecao) {
            System.out.println("buscarNoticiaUsuarioLogado");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return noticia;
    }
    
    public Noticia buscarNoticia(int identificador) {
        Noticia noticia = null;
        PreparedStatement pstatement;
        ResultSet resultado;
        String sql = "SELECT * FROM noticia WHERE idnoticia = ? AND BLOQUEADA = ?";

        try {
            pstatement = conexao.prepareStatement(sql);
            pstatement.setInt(1, identificador);
            pstatement.setBoolean(2, false);
            
            resultado = pstatement.executeQuery();

            while (resultado.next()) {
                int idnoticia = resultado.getInt("IDNOTICIA");
                int codigo_usuario = resultado.getInt("COD_USUARIO");
                int codigo_topico = resultado.getInt("COD_TOPICO");
                String conteudo = resultado.getString("TEXTO");
                long dataDoBancoMilisegundos = resultado.getDate("DATA_DE_PUBLICACAO").getTime();
                Date data_de_publicacao = new Date(dataDoBancoMilisegundos);
                String titulo = resultado.getString("TITULO");
                int quantidadeDeAvaliacoes = resultado.getInt("AVALIACAO");
                boolean bloqueada = resultado.getBoolean("BLOQUEADA");

                noticia = new Noticia();

                noticia.setIdentificador(idnoticia);
                noticia.setCodigoUsuario(codigo_usuario);
                noticia.setCodigoTopico(codigo_topico);
                noticia.setConteudo(conteudo);
                noticia.setDataDePublicacao(data_de_publicacao);
                noticia.setTitulo(titulo);
                noticia.setAvaliacao(quantidadeDeAvaliacoes);
                noticia.setBloqueio(bloqueada);
            }
        } catch (SQLException excecao) {
            System.out.println("buscarNoticia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
        return noticia;
    }

    public boolean editarNoticia(Noticia noticia) {
        PreparedStatement pstatement;
        String sql = "UPDATE noticia SET texto = ? , titulo = ?, cod_topico = ? WHERE idnoticia = ?";
                        
        try {
            pstatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstatement.setString(1, noticia.getConteudo());
            pstatement.setString(2, noticia.getTitulo());
            pstatement.setInt(3,noticia.getCodigoTopico());
            pstatement.setInt(4,noticia.getIdentificador());
            
            pstatement.executeUpdate();
            
        } catch (SQLException excecao) {
            System.out.println("editarNoticia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());            
            return false;
        }
        return true;
    }
    
    

}
