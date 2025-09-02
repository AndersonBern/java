package ListaDeContatos;

public class NomeEmail {
    public String nome;
    public String email;

    public NomeEmail(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }

    public String toString(){
        return nome + " -> " + email;
    }
}
