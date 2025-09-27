package Loja;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Estoque {

    private LinkedHashMap<Integer, Produto> produtos = new LinkedHashMap<>();
    private int nextId = 1;


    public Produto adicionar(String nome, int quantidade, double preco) {

        //Pega o ultimo ID, e incrementa +1
        Set<Integer> keys = produtos.keySet();
        List<Integer> keyList = new ArrayList<>(keys);
        nextId += keyList.getLast();

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


