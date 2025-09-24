package Loja;

import java.util.Scanner;

public class Leitura {
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
}
