package Loja;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Persistencia {

    public Gson gson = new Gson();
    public HashMap<Integer, Produto> produtos;
    public String caminho;

    public Persistencia(HashMap<Integer, Produto> produtos, String caminho) {
        this.produtos = produtos;
        this.caminho = caminho;
    }

    public void salvar(){
        try(FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(produtos, writer);
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e + ": Arquivo não salvo!");
        }
    }

    public LinkedHashMap<Integer, Produto> carregar() {
        Type tipo = new TypeToken<LinkedHashMap<Integer, Produto>>() {}.getType();

        try(FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, tipo);
        }
        catch (IOException e){
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }
}
