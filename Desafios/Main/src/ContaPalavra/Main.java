package ContaPalavra;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String frase;
        Integer contador;
        HashMap<String, Integer> contaPalavra = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        frase = sc.nextLine();
        String palavras[] = frase.split(" ");

        for(String palavra : palavras) {
            contador = 1;
            if(contaPalavra.containsKey(palavra)) {
                Integer p = contaPalavra.get(palavra);
                contaPalavra.put(palavra, p + 1);
            }
            else {
                contaPalavra.put(palavra, contador);
            }


        }

        System.out.println(contaPalavra);


    }
}
