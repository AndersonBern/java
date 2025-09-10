package RankingDeNotas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nome;
        Double nota;

        Double maior = 0.0;
        Double menor = 10.0;
        Double media = 0.0;
        String maiorNome = "";
        String menorNome = "";
        HashMap<String, Double> alunos = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            System.out.println("******************* CADASTER UM ALUNO *********************");
            System.out.print("Digite o nome: ");
            nome = sc.nextLine();

            System.out.print("Digite a nota: ");
            nota = Double.valueOf(sc.nextLine());

            alunos.put(nome, nota);
        }


        for(Map.Entry<String, Double> n : alunos.entrySet()) {

            Double novo = n.getValue();

            if(maior < novo ) {
                maior = novo;
                maiorNome = n.getKey();

            }if (menor > novo) {
                menor = novo;
                menorNome = n.getKey();
            }
            media += novo;

        }
        System.out.println("***********************************************************");
        System.out.println("O aluno com MAIOR nota: " + maiorNome);
        System.out.println("O alunor com MENOR nota: " + menorNome);
        System.out.println("O média da classe é: " + media / alunos.size());
    }

}
