package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Loja.Estoque.*;


public class Loja {

    private static final int OPCAO_ADICIONAR = 1;
    private static final int OPCAO_VENDER   = 2;
    private static final int OPCAO_REPOR    = 3;
    private static final int OPCAO_ESTOQUE = 4;
    private static final int OPCAO_SAIR     = 5;

    public static void mostrarMenu(){
        System.out.println("********************************************************************");
        System.out.println("[ 1 ] Adicionar Produto");
        System.out.println("[ 2 ] Vender Produto");
        System.out.println("[ 3 ] Repor Produto");
        System.out.println("[ 4 ] Listar Produtos");
        System.out.println("[ 5 ] Sair");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();
        estoque.adicionar("café", 1, 14.8);
        estoque.adicionar("coco", 3, 4.8);
        estoque.adicionar("bolo", 2, 5.7);

        boolean executando = true;
        while(executando){

            mostrarMenu();

            System.out.print("Digite uma opção: ");
            int opcao = 0;

            try{
                opcao = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
            }


            switch (opcao){

                case OPCAO_ADICIONAR:
                    System.out.print("Digite o NOME do produto: ");
                    String nome = sc.nextLine();

                    int quantidade = lerInteiro(sc, "Digite a QUANTIDADE do produto: ");

                    double preco = lerDouble(sc, "Digite o PREÇO do produto: ");

                    Produto novo = estoque.adicionar(nome, quantidade, preco);
                    System.out.println("Produto: " + novo.getNome() + " foi adicionado ao estoque!");
                    break;

                case OPCAO_VENDER:

                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja VENDER ?");

                    estoque.listarProdutos();

                    int id = lerInteiro(sc, "Digite uma opção: ");

                    int unidade = lerInteiro(sc, "Quantas unidades você deseja VENDER: ");

                    estoque.venderProduto(id, unidade);
                    break;

                case OPCAO_REPOR:
                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja REPOR ?");

                    estoque.listarProdutos();

                    int reposicao = lerInteiro(sc, "Digite uma opção: ");

                    int unidades = lerInteiro(sc, "Quantas unidades você deseja REPOR: ");

                    estoque.reporProduto(reposicao, unidades);

                    break;

                case OPCAO_ESTOQUE:
                    estoque.verEstoque();
                    break;

                case OPCAO_SAIR:
                    executando = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }
        sc.close();
    }
}
