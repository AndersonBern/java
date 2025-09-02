package ListaDeContatos;

import java.time.LocalDateTime;

public class Contato {

    public Integer id;
    public String nome;
    public String telefone;
    public String email;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public Contato(Integer id, String nome, String telefone, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Integer getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }
    public String toString(){
        return id + " - " + nome + " - " + email + " - " + telefone + " - " + createdAt + " / " + updatedAt;
    }
}
