package Filter;

import ListaDeContatos.Contato;
import ListaDeContatos.NomeEmail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        LocalDateTime updatedAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();

        ArrayList<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato(1, "Anderson Bernardo", "9999-9999", "Anderson@hotmail.com", createdAt.toString(), updatedAt.toString()));
        contatos.add(new Contato(2, "Andre Bruno", "9899-9899", "Andre@hotmail.com", createdAt.toString(), updatedAt.toString()));
        contatos.add(new Contato(3, "Juan Bernardo", "8899-8899", "Juan@hotmail.com", createdAt.toString(), updatedAt.toString()));
        contatos.add(new Contato(4, "Maria Eduarda", "8888-8888", "Maria@hotmail.com", createdAt.toString(), updatedAt.toString()));
        contatos.add(new Contato(5, "Elisangela Batista", "8877-8877", "Elisangela@hotmail.com", createdAt.toString(), updatedAt.toString()));

        List<Contato> lista = contatos.stream().sorted(Comparator.comparing(Contato::getNome)).collect(Collectors.toList());

        for(Contato c : lista){
            System.out.println(c);
        }

        List<NomeEmail> lista2 = lista.stream()
                .filter(contato -> contato.getId() > 3)
                .map(contato -> new NomeEmail(contato.getNome(), contato.getEmail()))
                .collect(Collectors.toList());

        for(NomeEmail c : lista2){
            System.out.println(c);
        }
    }
}
