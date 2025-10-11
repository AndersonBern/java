package lojaConsole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Indica que a classe é uma entidade que será mapeada para uma tabela.
@Entity

public class Produto {

    //Define o campo que será a chave primária da tabela.
    @Id
    private int id;        // chave primária auto-increment

    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Produto() {
        // necessário para o Hibernate
    }

    public int getId() {
        return id;
    }
    public String getNome(){
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public boolean vender(int qnt){
        if(qnt <=0 || qnt > quantidade){
            return false;
        }
        quantidade -= qnt;
        return true;
    }

    public boolean repor(int qnt){
        if(qnt > 0){
            quantidade += qnt;
            return true;
        }
        return false;
    }

    public String toString(){
        return "lojaConsole.Produto: " + nome + "\nQuantidade: " + quantidade + "\nPreço: R$ " + preco;
    }

}
