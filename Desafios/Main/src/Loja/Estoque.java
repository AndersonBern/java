package Loja;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Estoque {

    private final LinkedHashMap<Integer, Produto> produtos = new LinkedHashMap<>();
    private int nextId = 1;

    public Produto adicionar(String nome, int quantidade, double preco) {

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

    public HashMap<Integer, Produto> getProdutos(){
        return new LinkedHashMap<>(produtos);
    }
}


