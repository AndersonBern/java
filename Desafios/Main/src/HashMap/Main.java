package HashMap;

import ListaDeContatos.Contato;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        LocalDateTime updatedAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();

        ArrayList<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato(1,"Anderson Bernardo", "9999-9999", "Anderson@hotmail.com", createdAt.toString(), updatedAt.toString() ));
        contatos.add(new Contato(2,"Andre Bruno", "9899-9899", "Andre@hotmail.com", createdAt.toString(), updatedAt.toString() ));
        contatos.add(new Contato(3,"Juan Bernardo", "8899-8899", "Juan@hotmail.com", createdAt.toString(), updatedAt.toString() ));
        contatos.add(new Contato(4,"Maria Eduarda", "8888-8888", "Maria@hotmail.com", createdAt.toString(), updatedAt.toString() ));
        contatos.add(new Contato(5,"Elisangela Batista", "8877-8877", "Elisangela@hotmail.com", createdAt.toString(), updatedAt.toString() ));

        //HashMap para buscar contato por email
        HashMap<String, Contato> mapaContato = new HashMap<>();

        for (Contato c : contatos) {
            mapaContato.put(c.getEmail(), c);
        }

        System.out.println(BuscaContato(mapaContato, "Anderson@hotmail.com"));

        //Transformando a lista em Json
        Gson gson = new Gson();
        ArrayList<String> json = new ArrayList<>();

        for(Contato c : contatos) {
            //System.out.println(gson.toJson(c));
            json.add(gson.toJson(c));
        }
        System.out.println(json);


    }

    public static String BuscaContato(HashMap<String, Contato> mapaContato, String email){
        Contato user = mapaContato.get(email);

        if(user != null) {
            return user.getNome();
        }
        else{
            return "Email invalido! Tente novamente.";
        }
    }
}
