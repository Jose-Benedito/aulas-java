/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bene
 */
public class Usuario {
    private int id;
    private String nome;
    private String  endereco;
    private String telenoe;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelenoe() {
        return telenoe;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telenoe=" + telenoe + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
}
