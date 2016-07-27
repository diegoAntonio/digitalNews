package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Denuncia;

/**
 *
 * @author Andy
 */
public class DenunciaDAO {

    private final Connection conexao;

    public DenunciaDAO() {
        conexao = DAO.getConnection();
    }
    
    
    public void denunciarNoticia(Denuncia denuncia) {
        StringBuilder sql;
        PreparedStatement pstatement;

        sql = new StringBuilder("INSERT INTO denuncias ");
        sql.append("(cod_usuario, cod_noticia) ");
        sql.append("VALUES (?,?)");

        try {
            pstatement = conexao.prepareStatement(sql.toString());
            
            int identificadorNoticia = denuncia.getIdenficadorNoticia();
            int identificadorUsuario = denuncia.getIdenficadorUsuario();

            pstatement.setInt(1, identificadorUsuario);
            pstatement.setInt(2, identificadorNoticia);

            pstatement.executeUpdate();

        } catch (SQLException excecao) {
            System.out.println("denunciarNoticia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());
        }
    }
    
    public void retirarDenuncia(int identificador) {
        String sql;
        PreparedStatement pstatement;
                
        sql = "DELETE FROM denuncias WHERE cod_noticia = ?";
        
        try {
            pstatement = conexao.prepareStatement(sql);
            
            pstatement.setInt(1, identificador);
            
            pstatement.executeUpdate();
            
        } catch (SQLException excecao) {
            System.out.println("retirarDenuncia");
            System.out.println("MENSAGEM: " + excecao.getMessage());
            System.out.println("SQL State: " + excecao.getSQLState());            
        }
    }
    
}
