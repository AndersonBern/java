import java.lang.reflect.Array;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean bool = true;

        int[] colecaoDeInteiros = {1, 2, 3 ,4 ,5};
        int[] meusNumeros = new int[5];

        if (bool) {
            System.out.println("Verdadeiro");
        }else {
            System.out.println("Falso");
        }

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Bernardo");
        nomes.add("Maria");
        nomes.add("João");

        //nomes.remove(0);

        System.out.println(nomes);

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        for (String nome : nomes) {
            System.out.println(nome);
        }

        int contador = 0;
        while(contador < 5){
            System.out.println("Estou no while!");
            contador++;
        }

        double meuDouble = 3.0;
        int meuInt = (int) meuDouble;

        int meuInt2 = 5;
        double meuDouble2 = meuInt2;

        String minhaString = "10";
        int meuInt3 = Integer.parseInt(minhaString);

        String minhaString2 = String.valueOf(meuInt3);

        System.out.println(meuInt);
        System.out.println(meuInt2);
        System.out.println(meuInt3);
        System.out.println(minhaString2);

    }


}