package Loja;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

import static Loja.Loja.estoque;

public class LojaGUI {
    public static void main(String[] args){

        //Cria a janela principal(body)
        JFrame frame = new JFrame("Minha loja");

        //Redimensiona a janela(Width e Height)
        frame.setSize(600, 400);

        //Fecha a janela ao clicar no "X"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Define o Layout
        frame.setLayout(new BorderLayout());


        //Cria um painel para organizar os botões
        JPanel painelDeBotoes = new JPanel();

        // coloca os botões lado a lado
        painelDeBotoes.setLayout(new FlowLayout());

        //Criando botões de ação
        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoVender = new JButton("Vender");
        JButton botaoRepor = new JButton("Repor");
        JButton botaoListar = new JButton("Estoque");
        JButton botaoSalvar = new JButton("Salvar");

        //Adicionando os botões ao painel de botões
        painelDeBotoes.add(botaoAdicionar);
        painelDeBotoes.add(botaoVender);
        painelDeBotoes.add(botaoRepor);
        painelDeBotoes.add(botaoListar);
        painelDeBotoes.add(botaoSalvar);

        //Adicionando o painel de botões a JANELA PRINCIPAL(NORTH: Adiciona no NORTE da janela)
        frame.add(painelDeBotoes, BorderLayout.NORTH);


        //Cria a Area de Texto
        JTextArea areaTexto = new JTextArea();

        //Apenas leitura
        areaTexto.setEditable(false);

        //Cria uma barra de rolagem para a area de texto
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        //Adiciona a area de texto com rolagem no CENTRO da janela PRINCIPAL
        frame.add(scrollPane, BorderLayout.CENTER);

        //Torna a janela visivel
        frame.setVisible(true);


        Persistencia persistencia = new Persistencia(null, "produtos.json"); //cria persistencia com caminho
        LinkedHashMap<Integer, Produto> produtosCarregados = persistencia.carregar(); //lê do arquivo
        Estoque estoque = new Estoque(); //Cria a instância do estoque
        estoque.setProdutos(produtosCarregados); //Adiciona o estoque atualizado
        atualizarArea(areaTexto, estoque);

    }

    private static void atualizarArea(JTextArea areaTexto, Estoque estoque) {

        //Cria uma String Dinâmica, que cria todo o conteúdo abaixo em uma unica string;
        StringBuilder sb = new StringBuilder();

        //For-each para criar as Strings para cada produto
        estoque.getProdutos().forEach((id, produto) -> {
            sb.append("ID: ").append(id).append("\n")
                    .append("Nome: ").append(produto.getNome()).append("\n")
                    .append("Quantidade: ").append(produto.getQuantidade()).append("\n")
                    .append("Preço: ").append(produto.getPreco()).append(" R$").append("\n")
                    .append("---------------------------\n");;
        });

        //Atualiza a areaTexto com a String que criamos do Produto
        areaTexto.setText(sb.toString());
    }

}
