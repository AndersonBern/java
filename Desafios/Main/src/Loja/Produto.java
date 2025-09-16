package Loja;

public class Produto {
    String nome;
    Integer quant;
    Double preco;

    public Produto(String nome, Integer quant, Double preco){
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }
    public String getNome(){
        return nome;
    }

    public Integer getQuant() {
        return quant;
    }

    public Double getPreco() {
        return preco;
    }
}
