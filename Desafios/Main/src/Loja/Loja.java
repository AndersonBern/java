package Loja;

import java.util.HashMap;
import java.util.Scanner;

public class Loja {
    public static void main(String[] args){
        Integer id;
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Produto> catalogo = new HashMap<>();

        Boolean cont = false;
        while(!cont){
            System.out.println("********************************************************************");
            System.out.println("[ 1 ] Adicionar Produto");
            System.out.println("[ 2 ] Vender Produto");
            System.out.println("[ 3 ] Repor Produto");
            System.out.println("[ 4 ] Listar Produtos");
            System.out.println("[ 5 ] Sair");
            System.out.print("Digite uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Produto cadastrado!");
                    break;

                case 2:
                    System.out.println("Produto vendido com sucesso!");
                    break;

                case 3:
                    System.out.println("Produto reposto com sucesso!");
                    break;

                case 4:
                    System.out.println("Lista de produtos: ");
                    break;

                case 5:
                    cont = true;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }

    }
}
