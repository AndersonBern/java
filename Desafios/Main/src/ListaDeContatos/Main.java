package ListaDeContatos;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contato> contatos = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        Scanner cadastro = new Scanner(System.in);

        String opcao = "";

        while(!opcao.equals("0")) {

            System.out.println(
                    "\n" + "[1] Adicionar contato\n" +
                            "[2] Listar todos os contatos\n" +
                            "[3] Remover contato (por nome)\n" +
                            "[4] Buscar contato (por nome ou telefone)\n" +
                            "[5] Editar contato (alterar telefone ou email de um contato já existente)\n" +
                            "[0] Sair"
            );

            opcao = sc.next();

            switch (opcao) {

                case "1":

                    System.out.print("Digite o nome: ");
                    String nome = cadastro.nextLine();

                    System.out.print("Digite o Telefone: ");
                    String telefone = cadastro.nextLine();

                    System.out.print("Digite o E-mail: ");
                    String email = cadastro.nextLine();

                    contatos.add(new Contato(nome, telefone, email));
                    System.out.println("Contato adicionado!");
                    break;

                case "2":

                    for(Contato c : contatos){
                        System.out.println("*********************************************************************");
                        System.out.println("Nome: " + c.nome);
                        System.out.println("Telefone: " + c.telefone);
                        System.out.println("Email: " + c.email);
                    }
                    break;

                case "3":
                    System.out.print("Digite o nome do contato: ");
                    nome = cadastro.nextLine();

                    for(Contato listar : contatos){
                        if(listar.nome.contains(nome)){
                            contatos.remove(listar);
                            System.out.println("O contato: [" + nome + "] foi removido!");
                        }
                        else{
                            System.out.println("O contato: [" + nome + "] não existe!");
                        }
                        break;
                    }
                    break;

                case "4":
                    System.out.print("Digite o NOME ou TELEFONE do contato: ");
                    String dado = cadastro.nextLine();

                    for(Contato listar : contatos){
                        if(listar.nome.contains(dado) || listar.telefone.equalsIgnoreCase(dado)){
                            System.out.println("*********************************************************************");
                            System.out.println("Nome: " + listar.nome);
                            System.out.println("Telefone: " + listar.telefone);
                            System.out.println("E-mail: " + listar.email);
                        }
                        else{
                            System.out.println("Contato não encontrado! Nome/Telefone: [" + dado + "]");
                        }
                        break;
                    }
                    break;

                case "5":
                    System.out.print("Digite o NOME do contato: ");
                    nome = cadastro.nextLine();

                    for(Contato listar : contatos){
                        if(listar.nome.contains(nome)){
                            System.out.println("EDITAR contato: "+ nome);

                            System.out.print("Telefone: ");
                            telefone = cadastro.nextLine();
                            listar.telefone = telefone;

                            System.out.print("E-mail: ");
                            email = cadastro.nextLine();
                            listar.email = email;

                            System.out.println("Contato atualizado!");
                        }
                        else{
                            System.out.println("Contato não encontrado! Nome/Telefone: [" + nome + "]");
                        }
                        break;
                    }
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        }
        sc.close();
        cadastro.close();
    }
}
