/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import java.util.List;
import model.Livro;

/**
 *
 * @author guilh
 */
public class ControllerLivro {
    
    public Boolean cadastrarLivro(String titulo, String autor, String genero, String editora, 
                                  String ano_Publicacao, String numero_Paginas, String estoque, String isbn) throws Exception{
        
    if(!titulo.equals("") && !autor.equals("") && !genero.equals("") && !editora.equals("")  
       && !ano_Publicacao.equals("") && !numero_Paginas.equals("") && !estoque.equals("") && !isbn.equals("")){
        
        //Criando o objeto do livro
        Livro livro = new Livro(titulo, autor, genero, editora, ano_Publicacao, numero_Paginas, estoque, isbn);
        
        livro.cadastrarLivro(livro);
     return true;
    }
        return false;
    }
public List<Livro> pesquisarLivro(String titulo, String autor, String genero, String editora,
                                  String anoPublicacao, String numeroPaginas,String estoque,String isbn) throws SQLException { 
       Livro livro = new Livro();
    return livro.pesquisarLivro(titulo, autor, genero, editora);

 
    }
}

