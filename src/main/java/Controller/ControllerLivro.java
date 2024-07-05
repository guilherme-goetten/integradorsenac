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
                                    String isbn, String ano_Publicacao, String numero_Paginas) throws Exception{
        
    if(!titulo.equals("") && !autor.equals("") && !genero.equals("") && !editora.equals("") && !isbn.equals("")  
            && !ano_Publicacao.equals("") && !numero_Paginas.equals("")){
        
        //Criando o objeto do livro
        Livro livro = new Livro(titulo, autor, genero, editora, isbn, ano_Publicacao, numero_Paginas);
        
        livro.cadastrarLivro(livro);
     return true;
    }
        return false;
    }
public List<Livro> pesquisarLivro(String titulo, String autor, String genero, String editora,
                                  String isbn, String anoPublicacao, String numeroPaginas) throws SQLException { 
       Livro livro = new Livro();
    return livro.pesquisarLivro(titulo, autor, genero, editora, isbn, anoPublicacao, numeroPaginas);

 
    }
}

