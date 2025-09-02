package ListaDeContatos;

public class NomeTel {

    public String nome;
    public String telefone;

    public NomeTel(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String toString(){
        return nome + " -> " + telefone;
    }
}
