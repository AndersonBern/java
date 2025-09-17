package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Loja.Loja.listarProdutos;

public class Estoque {

    public static void verEstoque(HashMap<Integer, Produto> estoque){
        System.out.println("*********************** Estoque de produtos *********************** ");
        double total = 0.0;

        for(Map.Entry<Integer, Produto> p : estoque.entrySet()){

            System.out.println("ID: " + p.getKey());
            System.out.println("Produto: " + p.getValue().getNome());
            System.out.println("Quantidade: " + p.getValue().getQuantidade());
            System.out.println("Preço: " + p.getValue().getPreco() + " R$");
            System.out.println("--------------------------------------------------------------------");

            total +=  p.getValue().getPreco() * p.getValue().getQuantidade();
        }

        String totalFormatado = String.format("%.2f", total);
        System.out.println(" Valor TOTAL do estoque: " + totalFormatado + " R$");
    }

    public static void venderProduto(HashMap<Integer, Produto> estoque){
        Scanner sc = new Scanner(System.in);

        System.out.println("********************************************************************");
        System.out.println("Qual produto você deseja VENDER ?");

        listarProdutos(estoque);

        System.out.print("Digite uma opção: ");
        String venda = sc.nextLine();

        if(estoque.containsKey(Integer.valueOf(venda))){
            System.out.print("Quantas unidades de [ " + estoque.get(Integer.valueOf(venda)).getNome() + " ] você deseja VENDER: ");
            String unidade = sc.nextLine();

            int novaQuant = estoque.get(Integer.valueOf(venda)).getQuantidade() - Integer.parseInt(unidade);
            estoque.get(Integer.valueOf(venda)).setQuant(novaQuant);
            System.out.println("Produto vendido com sucesso!");

            if(novaQuant <= 0){
                estoque.remove(Integer.valueOf(venda));
            }
        }
        else{
            System.out.println("Produto não encontrado!");
        }
    }

    public static  void reporProduto(HashMap<Integer, Produto> estoque){
        Scanner sc = new Scanner(System.in);

        System.out.println("********************************************************************");
        System.out.println("Qual produto você deseja REPOR ?");

        listarProdutos(estoque);

        System.out.print("Digite uma opção: ");
        String reposicao = sc.nextLine();

        if(estoque.containsKey(Integer.valueOf(reposicao))){

            System.out.print("Quantas unidades de [ " + estoque.get(Integer.valueOf(reposicao))
                    .getNome() + " ] você deseja REPOR: ");
            String unidade = sc.nextLine();

            int novaQuant = estoque.get(Integer.valueOf(reposicao)).getQuantidade() + Integer.parseInt(unidade);

            estoque.get(Integer.valueOf(reposicao)).setQuant(novaQuant);
            System.out.println("Reposição feita com sucesso!");
        }
        else{
            System.out.println("Produto não encontrado!");
        }
    }

}


