package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Loja.Estoque.*;

public class Loja {
    public static void mostrarMenu(){
        System.out.println("********************************************************************");
        System.out.println("[ 1 ] Adicionar Produto");
        System.out.println("[ 2 ] Vender Produto");
        System.out.println("[ 3 ] Repor Produto");
        System.out.println("[ 4 ] Listar Produtos");
        System.out.println("[ 5 ] Sair");
    }

    public static void listarProdutos(HashMap<Integer, Produto> estoque){
        for(Map.Entry<Integer, Produto> p : estoque.entrySet()){
            System.out.println("[ " + p.getKey() + " ] " + p.getValue().getNome());
        }
    }

    public static void main(String[] args){

        Integer id = 3;
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Produto> estoque = new HashMap<>();
        estoque.put(1, new Produto("café", 1, 14.8));
        estoque.put(2, new Produto("coco", 3, 4.8));
        estoque.put(3, new Produto("bolo", 2, 5.7));

        boolean executando = true;
        while(executando){

            mostrarMenu();

            System.out.print("Digite uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao){
                case "1":
                    id++;

                    System.out.print("Digite o NOME do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a QUANTIDADE do produto: ");
                    int quantidade = Integer.parseInt(sc.nextLine());

                    System.out.print("Digite o PREÇO do produto: ");
                    String precoString = sc.nextLine();
                    double preco;

                    //Para aceitar virgula ou ponto
                    if(precoString.contains(",")){
                        preco = Double.parseDouble(precoString.replace(",", "."));
                    }
                    else{
                        preco = Double.parseDouble(precoString);
                    }

                    Produto produto = new Produto(nome, quantidade, preco);
                    estoque.put(id, produto);


                    System.out.println("Produto cadastrado ao estoque!");
                    break;

                case "2":
                    venderProduto(estoque);
                    break;

                case "3":
                    reporProduto(estoque);
                    break;

                case "4":
                    verEstoque(estoque);
                    break;

                case "5":
                    executando = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }
        sc.close();
    }
}
