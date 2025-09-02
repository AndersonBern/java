package ListaDeContatos;

import java.time.LocalDateTime;

public class Contato {

    public String nome;
    public String telefone;
    public String email;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public Contato(String nome, String telefone, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
}
