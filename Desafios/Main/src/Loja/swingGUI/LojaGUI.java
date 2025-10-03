package Loja.swingGUI;

import Loja.Estoque;
import Loja.Persistencia;
import Loja.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

import static Loja.swingGUI.AuxiliarGUI.auxiliar;

public class LojaGUI {
    public static void main(String[] args){

        //Cria a janela principal(body)
        JFrame frame = new JFrame("Minha loja");

        //Redimensiona a janela(Width e Height)
        frame.setSize(700, 500);

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


        Estoque estoque = new Estoque(); //Cria a instância do estoque
        PersistenciaGUI persistencia = new PersistenciaGUI(estoque.getProdutos(), "./produtos.json", frame); //cria persistencia com caminho
        LinkedHashMap<Integer, Produto> produtosCarregados = persistencia.carregar(); //lê do arquivo
        estoque.setProdutos(produtosCarregados); //Adiciona o estoque atualizado

        //Qaundo clicar no botão "Adicionar", adiciona o produto
        botaoAdicionar.addActionListener(e -> {

            String nome = LeituraGUI.lerString(frame);
            int quantidade = LeituraGUI.lerInteiro("Digite a QUANTIDADE do produto:", frame);
            double preco = LeituraGUI.lerDouble(frame);

            estoque.adicionar(nome, quantidade, preco);
            JOptionPane.showMessageDialog(frame, "Produto ADICIONADO com sucesso!");
            atualizarArea(areaTexto, estoque);

        });

        //Quando clicar no botão "Vender", vender produto
        botaoVender.addActionListener(e -> {
            auxiliar("vender", estoque, areaTexto, frame);
            atualizarArea(areaTexto, estoque);
        });

        //Quando clicar no botão "Repor", repor produto
        botaoRepor.addActionListener(e -> {
            auxiliar("repor", estoque, areaTexto, frame);
            atualizarArea(areaTexto, estoque);
        });

        //Quando clicar no botão "Estoque", aparece o estoque
        botaoListar.addActionListener(e -> atualizarArea(areaTexto, estoque));

        //Quando clicar no botão "Salvar", salva as alterações
        botaoSalvar.addActionListener(e -> {
            PersistenciaGUI persistenciaSalvar = new PersistenciaGUI(estoque.getProdutos(), "./produtos.json", frame);
            persistenciaSalvar.salvar();
        });

    }

    private static void atualizarArea(JTextArea areaTexto, Estoque estoque) {

        //Cria uma String Dinâmica, que une toda esta operação em uma única String.
        StringBuilder sb = new StringBuilder();

        //For-each para criar as Strings para cada produto
        estoque.getProdutos().forEach((id, produto) -> {
            sb.append("ID: ").append(id).append("\n")
                    .append("Nome: ").append(produto.getNome()).append("\n")
                    .append("Quantidade: ").append(produto.getQuantidade()).append("\n")
                    .append("Preço: ").append(produto.getPreco()).append(" R$").append("\n")
                    .append("---------------------------\n");
        });

        //Calcula o TOTAL do estoque
        double total = estoque.getProdutos().values()
                .stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                .sum();

        sb.append("Valor TOTAL do estoque: ").append(String.format("%.2f", total)).append(" R$");

        //Atualiza a areaTexto com a String que criamos do Produto
        areaTexto.setText(sb.toString());
    }

}
