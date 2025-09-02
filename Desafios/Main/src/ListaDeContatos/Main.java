package ListaDeContatos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        LocalDateTime updatedAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();

        ArrayList<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Anderson Bernardo", "9999-9999", "Anderson@hotmail.com", createdAt, updatedAt ));
        contatos.add(new Contato("Andre Bruno", "9899-9899", "Andre@hotmail.com", createdAt, updatedAt ));
        contatos.add(new Contato("Juan Bernardo", "8899-8899", "Juan@hotmail.com", createdAt, updatedAt ));
        contatos.add(new Contato("Maria Eduarda", "8888-8888", "Maria@hotmail.com", createdAt, updatedAt ));
        contatos.add(new Contato("Elisangela Batista", "8877-8877", "Elisangela@hotmail.com", createdAt, updatedAt ));

        List<NomeEmail> lista1 = contatos.stream()
                .map(contato -> new NomeEmail(contato.getNome(), contato.getEmail())).toList();

        for(NomeEmail contato : lista1){
            System.out.println(contato);
        }

        Scanner sc = new Scanner(System.in);
        Scanner cadastro = new Scanner(System.in);

        String opcao = "";


        /*while(!opcao.equals("0")) {

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

                    contatos.add(new Contato(nome, telefone, email, createdAt, updatedAt));
                    System.out.println("Contato adicionado!");
                    break;

                case "2":

                    for(Contato c : contatos){
                        System.out.println("*********************************************************************");
                        System.out.println("Nome: " + c.nome);
                        System.out.println("Telefone: " + c.telefone);
                        System.out.println("Email: " + c.email);
                        System.out.println("CreatedAt: " + c.createdAt);
                        System.out.println("UpdatedAt: " + c.updatedAt);
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
                            System.out.println("CreatedAt: " + listar.createdAt);
                            System.out.println("UpdatedAt: " + listar.updatedAt);

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
                            listar.updatedAt = LocalDateTime.now();

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
        cadastro.close();*/
    }
}
