package Loja;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
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
        return "Produto: " + nome + "\nQuantidade: " + quantidade + "\nPreço: R$ " + preco;
    }

}
