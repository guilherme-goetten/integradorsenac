/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Livro;

/**
 *
 * @author guilh
 */
public class ControllerLivro {
    
    public Boolean cadastrarLivro(String titulo, String autor, String genero, String editora, 
                                    String isbn, String anoPublicacao, String numeroPaginas) throws Exception{
        
    if(!titulo.equals("") && !autor.equals("") && !genero.equals("") && !editora.equals("") && !isbn.equals("")  
            && !anoPublicacao.equals("") && !numeroPaginas.equals("")){
        
        //Criando o objeto do livro
        Livro livro = new Livro(titulo, autor, genero, editora, isbn, anoPublicacao, numeroPaginas);
        
        livro.cadastrarLivro(livro);
     return true;
    }
        return false;
    }
    
}
