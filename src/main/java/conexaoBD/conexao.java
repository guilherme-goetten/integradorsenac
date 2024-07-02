/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

//Conexão com o banco de dados.
import java.sql.Connection;

//Carregar o driver de conexão.
import java.sql.DriverManager;

//Biblioteca que traz erros de banco de dados.
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class conexao {
        public Connection getConnection(){
        
        //Variavel de conexao, ela inicia nula.
        Connection conn = null;
    
        //Variaveis de conexão com o mySQL
        String servidor = "localhost";
        String porta = "3306";
        String usuario = "root";
        String senha = "senacgoetten";
        String banco = "biblioteca_db";
        
        //Verificar se conectou com o driver de conexão
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Executa a conexão
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/" + banco, usuario, senha);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_integrador", usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

    

