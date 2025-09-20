package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {

    private HashMap<Integer, Produto> produtos = new HashMap<>();
    private int nextId = 1;

    public static int lerInteiro(Scanner sc, String mensagem) {

        while (true) {
            System.out.print(mensagem);

            try {
                int quantidade = Integer.parseInt(sc.nextLine());

                if(quantidade <= 0){
                    System.out.println("Digite um numero MAIOR que 0.");
                }else {
                    return quantidade;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
            }
        }
    }

    public static double lerDouble(Scanner sc, String mensagem){
        while (true) {

            System.out.print(mensagem);

            //Para aceitar virgula ou ponto
            try {
                double preco = Double.parseDouble(sc.nextLine().replace(",", "."));
                if (preco <= 0) {
                    System.out.println("Digite um valor MAIOR que 0!");
                } else {
                    return preco;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }
    }

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

    public void verEstoque(){
        System.out.println("*********************** Estoque de produtos *********************** ");
        double total = 0.0;

        for(Map.Entry<Integer, Produto> p : produtos.entrySet()){

            System.out.println("ID: " + p.getKey());
            System.out.println(p.getValue());
            System.out.println("--------------------------------------------------------------------");

            total +=  p.getValue().getPreco() * p.getValue().getQuantidade();
        }

        String totalFormatado = String.format("%.2f", total);
        System.out.println(" Valor TOTAL do estoque: " + totalFormatado + " R$");
    }

    public void listarProdutos(){
        for(Map.Entry<Integer, Produto> p : produtos.entrySet()){
            System.out.println("[ " + p.getKey() + " ] " + p.getValue().getNome());
        }
    }
}


