/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livros;

/**
 *
 * @author bene
 */
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String addData;
    private byte[] foto;

    public Livro(int id, String titulo, String autor, String addData, byte[] foto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.addData = addData;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAddData() {
        return addData;
    }

    public byte[] getFoto() {
        return foto;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", addData=" + addData + ", foto=" + foto + '}';
    }
    
    
}
