
package conexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
//import model.Livro;

public class ConexaoLivro {
    
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_integrador";
    private static final String USER = "root";
    private static final String PASSWORD = "senacgoetten";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }

//    public void cadastrarLivro(Livro livro) throws SQLException {
//        String sql = "INSERT INTO livros (titulo, autor, genero, editora, isbn, anoPublicacao, numeroPaginas) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, livro.getTitulo());
//            stmt.setString(2, livro.getAutor());
//            stmt.setString(3, livro.getGenero());
//            stmt.setString(4, livro.getEditora());
//            stmt.setString(5, livro.getIsbn());
//            stmt.setString(6, livro.getAnoPublicacao());
//            stmt.setString(7, livro.getNumeroPaginas());
//            stmt.executeUpdate();
        }
    
