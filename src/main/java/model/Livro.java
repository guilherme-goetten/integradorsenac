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
    private String isbn;
    private String anoPublicacao;
    private String numeroPaginas;
    
    //Criando os contrutores da classe.
    
    public Livro(){}
    
    public Livro(String titulo, String autor, String genero, String editora, 
                 String isbn, String anoPublicacao, String numeroPaginas){
    //Construtores.
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public List<Livro> pesquisarLivro(String titulo, String autor, String genero, String editora, String isbn, String ano_Publicacao, String numero_Paginas) throws SQLException {
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
        if (isbn != null && !isbn.isEmpty()) {
            sql.append(" AND isbn LIKE ?");
        }
        if (anoPublicacao != null && !anoPublicacao.isEmpty()) {
            sql.append(" AND ano_Publicacao = ?");
        }
        if (numeroPaginas != null && !numeroPaginas.isEmpty()) {
            sql.append(" AND numero_Paginas = ?");
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
            if (isbn != null && !isbn.isEmpty()) {
                stmt.setString(index++, "%" + isbn + "%");
            }
            if (anoPublicacao != null && !anoPublicacao.isEmpty()) {
                stmt.setString(index++, anoPublicacao);
            }
            if (numeroPaginas != null && !numeroPaginas.isEmpty()) {
                stmt.setString(index++, numeroPaginas);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getString("editora"),
                        rs.getString("isbn"),
                        rs.getString("ano_Publicacao"),
                        rs.getString("numero_Paginas")
                    );
                    resultados.add(livro);
                }
            }
        }
        return resultados;
    }
    // Método para cadastrar livro
    public void cadastrarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO tb_livros (titulo, autor, genero, editora, isbn, ano_Publicacao, numero_Paginas) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getIsbn());
            stmt.setString(6, livro.getAnoPublicacao());
            stmt.setString(7, livro.getNumeroPaginas());
            
            stmt.executeUpdate();
        }
    }
    // Método para excluir livro
    public void excluirLivro(String isbn) throws SQLException {
        String sql = "DELETE FROM tb_livros WHERE isbn = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, isbn);
            stmt.executeUpdate();
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

