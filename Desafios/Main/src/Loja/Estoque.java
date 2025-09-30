package Loja;

import java.util.*;

public class Estoque {

    private LinkedHashMap<Integer, Produto> produtos = new LinkedHashMap<>();
    private int nextId;


    public Produto adicionar(String nome, int quantidade, double preco) {

        // Se o mapa não estiver vazio, pega o maior ID e soma 1
        if (!produtos.isEmpty()) {
            nextId = produtos.keySet()
                    .stream()
                    .max(Integer::compareTo)  // pega o maior ID
                    .orElse(0) + 1;
            // se estiver vazio, retorna 0 + 1
        } else {
            nextId = 1; // caso o mapa esteja vazio
        }

        Produto produto = new Produto(nome, quantidade, preco);
        produtos.put(nextId, produto);
        nextId++;
        return produto;
    }

    public boolean venderProduto(int id, int unidade){

        if(!produtos.containsKey(id)){
            return false;
        }
        else{
            Produto produto = produtos.get(id);
            boolean vendido = produto.vender(unidade);

            if(vendido && produto.getQuantidade() <= 0) {
                produtos.remove(id);
            }
            return vendido;
        }
    }

    public boolean reporProduto(int id, int unidade){

        if(!produtos.containsKey(id)){
            return false;

        }
        else{
            Produto produto = produtos.get(id);
            boolean reposto = produto.repor(unidade);

            return reposto;
        }
    }

    public LinkedHashMap<Integer, Produto> getProdutos(){
        return new LinkedHashMap<>(produtos);
    }
    public void setProdutos(LinkedHashMap<Integer, Produto> produtosCarregados) {
        this.produtos = produtosCarregados;
    }
}


