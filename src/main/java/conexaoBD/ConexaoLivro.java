/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Livro;

/**
 *
 * @author guilh
 */
public class ConexaoLivro {

    public void cadastrarLivro(Livro livro) throws Exception{
        String sql = "INSERT INTO tb_livros(TITULO, AUTOR, GENERO, EDITORA, ISBN, ANO_PUBLICACAO, NUMERO_PAGINAS) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = new conexao().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1,livro.getTitulo());
            ps.setString(2,livro.getAutor());
            ps.setString(3,livro.getGenero());
            ps.setString(4,livro.getEditora());
            ps.setString(5,livro.getIsbn());
            ps.setString(6,livro.getAnoPublicacao());
            ps.setString(7,livro.getNumeroPaginas());
            
            ps.execute();
        
        }catch (SQLException e){
            throw new Exception ("Erro ao cadastrar cliente:" + e);
        }finally{
            // Fecha o statement
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new Exception ("Erro ao fechar o statement" + e);
            }
            //Fecha a conexão.
            try {
                if(conn != null){
                conn.close();
                }
            } catch (SQLException e) {
                throw new Exception ("Erro ao fechar a conexão:" + e);
            }
        }
    }
}
