package ExerciciosHashMap;

public class Produto {

    String produto;
    Double valor;

    public void Produto(String produto, Double valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto(){
        return produto;
    }
    public Double getValor(){
        return valor;
    }
}
