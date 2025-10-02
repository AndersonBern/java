package Loja.swingGUI;

import Loja.Estoque;
import javax.swing.*;


public class AuxiliarGUI {

    private static final String MSG_VENDA_SUCESSO = "Produto VENDIDO com sucesso!";
    private static final String MSG_VENDA_FALHA = "Venda não concluida! Estoque INSUFICIENTE ou produto não ENCONTRADO!";
    private static final String MSG_REPOR_SUCESSO = "Produto REPOSTO com sucesso!";
    private static final String MSG_REPOR_FALHA = "Reposição não concluida! QUANTIDADE inválida ou produto não ENCONTRADO!";
    private static final String MSG_OPCAO = "Digite uma opção: ";

    static void auxiliar(String acao, Estoque estoque, JTextArea areaTexto) {

        listarProdutos(areaTexto, estoque);

        int id = LeituraGUI.lerInteiro("Qual produto você deseja " + acao.toUpperCase() + ":");

        int unidade = LeituraGUI.lerInteiro("Quantas UNIDADES você deseja " + acao.toUpperCase() + ":");

        boolean sucesso;

        switch (acao.toLowerCase()){

            case "vender":
                sucesso = estoque.venderProduto(id, unidade);

                JOptionPane.showMessageDialog(null, sucesso ? MSG_VENDA_SUCESSO : MSG_VENDA_FALHA);
                break;

            case "repor":
                sucesso = estoque.reporProduto(id, unidade);

                JOptionPane.showMessageDialog(null, sucesso ? MSG_REPOR_SUCESSO : MSG_REPOR_FALHA);
                break;

            default:
                JOptionPane.showMessageDialog(null,"Ação inválida!");
                break;
        }

    }

    public static void listarProdutos(JTextArea areaTexto, Estoque estoque) {
        StringBuilder sb = new StringBuilder();
        estoque.getProdutos().forEach((id, produto) -> {

            sb.append("[ " + id + " ] ").append(produto.getNome()).append("\n");

        });
        areaTexto.setText(sb.toString());
    }
}
