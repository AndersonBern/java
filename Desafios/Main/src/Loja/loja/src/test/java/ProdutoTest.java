/*import Loja.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class ProdutoTest {

    @Test
    void vender() {
        Produto p = new Produto("Arroz", 10, 5.0);

        // Teste venda válida
        assertTrue(p.vender(5));           // deve retornar true
        assertEquals(5, p.getQuantidade()); // quantidade deve ser 5

        // Teste venda inválida
        assertFalse(p.vender(10));          // não pode vender mais que o estoque
        assertEquals(5, p.getQuantidade()); // quantidade não muda
    }

    @Test
    void repor() {
        Produto p = new Produto("Feijão", 3, 7.0);

        // Teste reposição válida
        assertTrue(p.repor(2));
        assertEquals(5, p.getQuantidade());

        // Teste reposição inválida
        assertFalse(p.repor(0));
        assertEquals(5, p.getQuantidade()); // quantidade não muda
    }
}*/