/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Livro {
    
    //Criando os atributos da classe.
    
    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private String anoPublicacao;
    private String numeroPaginas;
    private String estoque;
    private String isbn;
    
    //Criando os contrutores da classe.
    
    public Livro(){}
    
    public Livro(String titulo, String autor, String genero, String editora, 
                 String anoPublicacao, String numeroPaginas, String estoque, String isbn){
    //Construtores.
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
        this.estoque = estoque;
        this.isbn = isbn;
    }

 // Getters e setters para os campos

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
        public String getestoque() {
        return estoque;
    }

    public void setestoque(String isbn) {
        this.estoque = estoque;
    }
    
        public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean isDisponivel() throws SQLException {
        Connection conn = getConnection();
        String sql = "SELECT estoque FROM tb_livros WHERE titulo = ? AND autor = ? AND genero = ? AND ano_publicacao = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.titulo);
        stmt.setString(2, this.autor);
        stmt.setString(3, this.genero);
        stmt.setString(4, this.anoPublicacao);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int estoque = rs.getInt("estoque");
            return estoque > 0;
        } else {
            return false;
        }
    }

    public void baixarEstoque() throws SQLException {
        Connection conn = getConnection();
        String sql = "UPDATE tb_livros SET estoque = estoque - 1 WHERE titulo = ? AND autor = ? AND genero = ? AND ano_publicacao = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.titulo);
        stmt.setString(2, this.autor);
        stmt.setString(3, this.genero);
        stmt.setString(4, this.anoPublicacao);
        stmt.executeUpdate();
    }
    public void aumentarEstoque() throws SQLException {
    Connection conn = getConnection();
    String sql = "UPDATE tb_livros SET estoque = estoque + 1 WHERE titulo = ? AND autor = ? AND genero = ? AND ano_publicacao = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, this.titulo);
    stmt.setString(2, this.autor);
    stmt.setString(3, this.genero);
    stmt.setString(4, this.anoPublicacao);
    stmt.executeUpdate();
}
    
    public List<Livro> pesquisarLivro(String titulo, String autor, String genero, String editora) throws SQLException {
        List<Livro> resultados = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM tb_livros WHERE 1=1");

        if (titulo != null && !titulo.isEmpty()) {
            sql.append(" AND titulo LIKE ?");
        }
        if (autor != null && !autor.isEmpty()) {
            sql.append(" AND autor LIKE ?");
        }
        if (genero != null && !genero.isEmpty()) {
            sql.append(" AND genero LIKE ?");
        }
        if (editora != null && !editora.isEmpty()) {
            sql.append(" AND editora LIKE ?");
        }
        if (anoPublicacao != null && !anoPublicacao.isEmpty()) {
            sql.append(" AND ano_Publicacao = ?");
        }
        if (numeroPaginas != null && !numeroPaginas.isEmpty()) {
            sql.append(" AND numero_Paginas = ?");
        }
        if (estoque != null && !estoque.isEmpty()) {
            sql.append(" AND estoque LIKE ?");
        }
        if (isbn != null && !isbn.isEmpty()) {
            sql.append(" AND isbn LIKE ?");
        }

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            int index = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(index++, "%" + titulo + "%");
            }
            if (autor != null && !autor.isEmpty()) {
                stmt.setString(index++, "%" + autor + "%");
            }
            if (genero != null && !genero.isEmpty()) {
                stmt.setString(index++, "%" + genero + "%");
            }
            if (editora != null && !editora.isEmpty()) {
                stmt.setString(index++, "%" + editora + "%");
            }
            if (anoPublicacao != null && !anoPublicacao.isEmpty()) {
                stmt.setString(index++, anoPublicacao);
            }
            if (numeroPaginas != null && !numeroPaginas.isEmpty()) {
                stmt.setString(index++, numeroPaginas);
            }
            if (estoque != null && !estoque.isEmpty()) {
                stmt.setString(index++, "%" + estoque + "%");
            }
            if (isbn != null && !isbn.isEmpty()) {
                stmt.setString(index++, "%" + isbn + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getString("editora"),                       
                        rs.getString("ano_Publicacao"),
                        rs.getString("numero_Paginas"),
                        rs.getString("estoque"),
                        rs.getString("isbn")
                    );
                    resultados.add(livro);
                }
            }
        }
        return resultados;
    }
    // Método para cadastrar livro
    public void cadastrarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO tb_livros (titulo, autor, genero, editora, ano_Publicacao, numero_Paginas, estoque, isbn) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            stmt.setString(4, livro.getEditora());          
            stmt.setString(5, livro.getAnoPublicacao());
            stmt.setString(6, livro.getNumeroPaginas());
            stmt.setString(7, livro.getestoque());
            stmt.setString(8, livro.getIsbn());
            
            stmt.executeUpdate();
        }
    }
    // Método para excluir livro
    public void excluirLivro(String titulo) throws SQLException {
        
        String sql = "DELETE FROM tb_livros WHERE TITULO = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, titulo);
            stmt.executeUpdate();
        }
    }
        public void editarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE tb_livros SET TITULO = ?, AUTOR = ?, GENERO = ?, EDITORA = ?, ANO_PUBLICACAO = ?, NUMERO_PAGINAS = ?, ESTOQUE = ? WHERE ISBN = ?";
       
        try (Connection conn = getConnection()) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(0, livro.getTitulo());
            pstm.setString(1, livro.getAutor());
            pstm.setString(2, livro.getGenero());
            pstm.setString(3, livro.getEditora());
            pstm.setString(4, livro.getAnoPublicacao());
            pstm.setString(5, livro.getNumeroPaginas());
            pstm.setString(6, livro.getestoque());
            pstm.setString(7, livro.getIsbn());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated >= 0 ) {
                System.out.println("Livro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum livro encontrado com o ISBN fornecido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o livro: " + e.getMessage());
            throw e;
        }
    }

    // Método para obter conexão com o banco de dados
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/biblioteca_integrador";
        String user = "root";
        String password = "senacgoetten";
        return DriverManager.getConnection(url, user, password);
    }
}

