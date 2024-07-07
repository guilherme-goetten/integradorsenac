
package conexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Livro;

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

    public void editarLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
