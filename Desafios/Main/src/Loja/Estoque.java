package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Loja.Loja.listarProdutos;

public class Estoque {

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

    public static void adicionar(int id, HashMap<Integer, Produto> estoque, Scanner sc) {

        System.out.print("Digite o NOME do produto: ");
        String nome = sc.nextLine();

        int quantidade = lerInteiro(sc, "Digite a QUANTIDADE do produto: ");

        double preco = lerDouble(sc, "Digite o PREÇO do produto: ");

        Produto produto = new Produto(nome, quantidade, preco);
        estoque.put(id, produto);


        System.out.println("Produto cadastrado ao estoque!");
    }

    public static void venderProduto(HashMap<Integer, Produto> estoque, Scanner sc){

        System.out.println("********************************************************************");
        System.out.println("Qual produto você deseja VENDER ?");

        listarProdutos(estoque);

        int venda = lerInteiro(sc, "Digite uma opção: ");

        Produto produto = estoque.get(venda);

        if(estoque.containsKey(venda)){

            int unidade = lerInteiro(sc, "Quantas unidades de [ " + produto.getNome()
                    + " ] você deseja VENDER: ");

            boolean vendido = produto.vender(unidade);

            if(vendido && produto.getQuantidade() <= 0){
                estoque.remove(venda);
            }
        }
        else{
            System.out.println("Produto não encontrado!");
        }
    }

    public static  void reporProduto(HashMap<Integer, Produto> estoque, Scanner sc){

        System.out.println("********************************************************************");
        System.out.println("Qual produto você deseja REPOR ?");

        listarProdutos(estoque);

        int reposicao = lerInteiro(sc, "Digite uma opção: ");

        Produto produto = estoque.get(reposicao);

        if(estoque.containsKey(reposicao)){

            int unidade = lerInteiro(sc, "Quantas unidades de [ " + produto.getNome()
                    + " ] você deseja REPOR: ");

            boolean reposto = produto.repor(unidade);
        }
        else{
            System.out.println("Produto não encontrado!");
        }
    }

    public static void verEstoque(HashMap<Integer, Produto> estoque){
        System.out.println("*********************** Estoque de produtos *********************** ");
        double total = 0.0;

        for(Map.Entry<Integer, Produto> p : estoque.entrySet()){

            System.out.println("ID: " + p.getKey());
            System.out.println(p.getValue());
            System.out.println("--------------------------------------------------------------------");

            total +=  p.getValue().getPreco() * p.getValue().getQuantidade();
        }

        String totalFormatado = String.format("%.2f", total);
        System.out.println(" Valor TOTAL do estoque: " + totalFormatado + " R$");
    }
}


