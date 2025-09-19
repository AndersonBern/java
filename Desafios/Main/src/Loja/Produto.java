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
        if(qnt <= quantidade){
            quantidade -= qnt;

            System.out.println("Venda feita com sucesso!");
            return true;
        }
        System.out.println("Estoque INSUFICIENTE! Só temos " + quantidade + " unidade(s) de " + nome + ".");
        return false;
    }

    public boolean repor(int qnt){
        if(qnt > 0){
            quantidade += qnt;
            System.out.println("Reposição feita com sucesso! Quantidade atual: " + quantidade + ".");

            return true;
        }
        System.out.println("Quantidade inválida! Digite um valor MAIOR que 0.");
        return false;
    }

    public String toString(){
        return "Produto: " + nome + "\nEstoque: " + quantidade + "\nPreço: R$ " + preco;
    }

}
