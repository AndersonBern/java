package Loja.test;

import Loja.Persistencia;
import Loja.Produto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

class PersistenciaTest {

    @Test
    void salvarECarregar() {
        String caminhoTeste = "teste_produtos.json";

        // Cria alguns produtos
        HashMap<Integer, Produto> produtos = new HashMap<>();
        produtos.put(1, new Produto("Arroz", 10, 5.0));
        produtos.put(2, new Produto("Feijão", 5, 7.0));

        Persistencia persistencia = new Persistencia(produtos, caminhoTeste);

        // Salva no arquivo
        persistencia.salvar();

        // Carrega do arquivo
        LinkedHashMap<Integer, Produto> carregados = persistencia.carregar();

        // Verifica se os produtos foram carregados corretamente
        assertEquals(2, carregados.size());
        assertEquals("Arroz", carregados.get(1).getNome());
        assertEquals(5, carregados.get(2).getQuantidade());

        // Limpa arquivo de teste
        new File(caminhoTeste).delete();
    }
}
