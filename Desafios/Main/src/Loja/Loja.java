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

    public static void listarProdutos(HashMap<Integer, Produto> estoque){
        for(Map.Entry<Integer, Produto> p : estoque.entrySet()){
            System.out.println("[ " + p.getKey() + " ] " + p.getValue().getNome());
        }
    }

    public static void main(String[] args){

        int id = 3;
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Produto> estoque = new HashMap<>();
        estoque.put(1, new Produto("café", 1, 14.8));
        estoque.put(2, new Produto("coco", 3, 4.8));
        estoque.put(3, new Produto("bolo", 2, 5.7));

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
                    id++;
                    adicionar(id, estoque, sc);
                    break;

                case OPCAO_VENDER:
                    venderProduto(estoque, sc);
                    break;

                case OPCAO_REPOR:
                    reporProduto(estoque, sc);
                    break;

                case OPCAO_ESTOQUE:
                    verEstoque(estoque);
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
