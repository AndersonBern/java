import lojaConsole.Estoque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
        estoque.adicionar("Arroz", 10, 5.0);
        estoque.adicionar("Feijão", 5, 7.0);
    }

    @Test
    void venderProdutoValido() {
        // Vender 3 unidades do ID 1 (Arroz)
        boolean resultado = estoque.venderProduto(1, 3);
        assertTrue(resultado);
        assertEquals(7, estoque.getProdutos().get(1).getQuantidade());
    }

    @Test
    void venderProdutoMaiorQueEstoque() {
        // Tentar vender 20 unidades do ID 2 (Feijão)
        boolean resultado = estoque.venderProduto(2, 20);
        assertFalse(resultado);
        assertEquals(5, estoque.getProdutos().get(2).getQuantidade());
    }

    @Test
    void venderProdutoInexistente() {
        boolean resultado = estoque.venderProduto(999, 1);
        assertFalse(resultado);
    }

    @Test
    void reporProdutoValido() {
        boolean resultado = estoque.reporProduto(2, 5);
        assertTrue(resultado);
        assertEquals(10, estoque.getProdutos().get(2).getQuantidade());
    }

    @Test
    void reporProdutoInexistente() {
        boolean resultado = estoque.reporProduto(999, 5);
        assertFalse(resultado);
    }

}