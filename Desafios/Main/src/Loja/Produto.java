package Loja;

public class Produto {
    private String nome;
    private Integer quantidade;
    private Double preco;

    public Produto(String nome, Integer quantidade, Double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getNome(){
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuant(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

}
