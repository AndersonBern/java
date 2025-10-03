package Loja.swingGUI;

import Loja.Estoque;
import javax.swing.*;


public class AuxiliarGUI {

    private static final String MSG_VENDA_SUCESSO = "Produto VENDIDO com sucesso!";
    private static final String MSG_VENDA_FALHA = "Venda não concluida! Estoque INSUFICIENTE ou produto não ENCONTRADO!";
    private static final String MSG_REPOR_SUCESSO = "Produto REPOSTO com sucesso!";
    private static final String MSG_REPOR_FALHA = "Reposição não concluida! QUANTIDADE inválida ou produto não ENCONTRADO!";

    static void auxiliar(String acao, Estoque estoque, JTextArea areaTexto, JFrame frame) {

        listarProdutos(areaTexto, estoque);

        int id = LeituraGUI.lerInteiro("Qual produto você deseja " + acao.toUpperCase() + ":", frame);

        int unidade = LeituraGUI.lerInteiro("Quantas UNIDADES você deseja " + acao.toUpperCase() + ":", frame);

        boolean sucesso;

        switch (acao.toLowerCase()){

            case "vender":
                sucesso = estoque.venderProduto(id, unidade);

                JOptionPane.showMessageDialog(frame, sucesso ? MSG_VENDA_SUCESSO : MSG_VENDA_FALHA);
                break;

            case "repor":
                sucesso = estoque.reporProduto(id, unidade);

                JOptionPane.showMessageDialog(frame, sucesso ? MSG_REPOR_SUCESSO : MSG_REPOR_FALHA);
                break;

            default:
                JOptionPane.showMessageDialog(frame,"Ação inválida!");
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
