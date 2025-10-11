package swingGUI;

import lojaConsole.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PersistenciaGUI {

    public Gson gson = new Gson();
    public HashMap<Integer, lojaConsole.Produto> produtos;
    public String caminho;
    public JFrame frame;

    public PersistenciaGUI(HashMap<Integer, Produto> produtos, String caminho, JFrame frame) {
        this.produtos = produtos;
        this.caminho = caminho;
        this.frame = frame;
    }

    public void salvar(){
        try(FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(produtos, writer);
            writer.flush();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(frame,"Arquivo não salvo!");
        }
    }

    public LinkedHashMap<Integer, Produto> carregar() {
        Type tipo = new TypeToken<LinkedHashMap<Integer, lojaConsole.Produto>>() {}.getType();

        try(FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, tipo);
        }
        catch (IOException e){
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }
}

