package Tradutor;

import java.util.HashMap;
import java.util.Scanner;

public class Tradutor {
    public static void main(String[] args){

        HashMap<String, String> palavras = new HashMap<>();
        palavras.put("dog", "cachorro");
        palavras.put("cat", "gato");
        palavras.put("bird", "passaro");
        palavras.put("duck", "pato");
        palavras.put("frog", "sapo");

        Scanner sc = new Scanner(System.in);
        boolean cont = false;
        while(!cont){
            System.out.print("Digite um animal (em inglês): ");
            String animal = sc.nextLine();

            if(palavras.containsKey(animal)){
                System.out.println("Em português é: " + palavras.get(animal));
                cont = true;
            }
            else{
                System.out.println("Animal não encontrado!");
            }
        }
    }
}
