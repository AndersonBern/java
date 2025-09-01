package Cadastro;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String nome;

        String opcao = "";

        while(!opcao.equalsIgnoreCase("0")){

            System.out.println("[1] Adicionar nome");
            System.out.println("[2] Listar nomes");
            System.out.println("[3] Remover nome");
            System.out.println("[4] Buscar nome");
            System.out.println("[0] Sair");

            opcao = sc.next();

            switch (opcao) {
                case "1":
                    System.out.print("Digite um nome: ");
                    nome = sc.next();
                    list.add(nome);
                    System.out.println("O nome: [" + nome + "] foi adicionado!");
                    break;

                case "2":
                    System.out.println("Nomes na lista:");
                    for (String n : list) {
                        System.out.println("- " + n);
                    }
                    break;

                case "3":

                    System.out.print("Digite um nome da lista: ");
                    nome = sc.next();

                    while(true) {
                        if (list.contains(nome)) {
                            System.out.println("O nome: [" + nome + "] foi removido!");
                            list.remove(nome);
                            break;

                        } else {
                            System.out.println("Este nome não existe na lista!");
                            System.out.print("Digite um nome da lista: ");
                            nome = sc.next();

                        }
                    }
                    break;

                case "4":
                    System.out.print("Digite o nome que deseja buscar: ");
                    nome = sc.next();

                    while(true){
                        if(list.contains(nome)){
                            System.out.println("O nome: [" + nome + "] existe na lista!");
                            break;
                        }
                        else {
                            System.out.println("O nome: [" + nome + "] NÃO existe na lista!");
                           break;
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        }
        sc.close();
    }


}
