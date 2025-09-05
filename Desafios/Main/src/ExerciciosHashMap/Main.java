package ExerciciosHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {

        String produto = "";
        Double valor = 0.0;
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> ListaProdutos = new HashMap<>();

        for(int i = 0; i < 5 ; i++) {

            System.out.print("Digite um produto: ");
            produto = sc.nextLine();

            System.out.print("Digite o valor: ");
            valor = Double.valueOf(sc.nextLine());

            ListaProdutos.put(produto, valor);
            System.out.println("Produto cadastrado!");
        }

        System.out.print("Buscar produto: ");
        produto = sc.nextLine();

        int c = 0;
        while( c < 1) {
            if (buscaProduto(ListaProdutos, produto) == null) {
                System.out.println("Produto inválido! Tente novamente.");
                System.out.print("Buscar produto: ");
                produto = sc.nextLine();
            }
            else {
                System.out.println("Preço: " + buscaProduto(ListaProdutos, produto) + "R$");
                c++;
            }
        }

    }

    public static Double buscaProduto(HashMap<String, Double> hashMap, String produto) {
        Double buscador = hashMap.get(produto);

        if(buscador != null) {
            return buscador;
        }
        else{
            return null;
        }

    }


}
