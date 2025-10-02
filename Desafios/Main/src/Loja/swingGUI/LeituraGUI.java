package Loja.swingGUI;

import Loja.Estoque;

import javax.swing.*;

public class LeituraGUI {

    public static String lerString() {

        while (true){

            String nome = JOptionPane.showInputDialog("Digite o NOME do produto: ");

            if(nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um nome válido!");
            }
            else{
                return nome;
            }
        }
    }

    public static int lerInteiro(String mensagem) {

        while (true) {

            try {
                int quantidade = Integer.parseInt(
                        JOptionPane.showInputDialog(mensagem)
                );

                if(quantidade <= 0){
                    JOptionPane.showMessageDialog(null, "Digite um numero MAIOR que 0.");
                }else {
                    return quantidade;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Entrada inválida! Digite apenas números INTEIROS.");
            }
        }
    }

    public static double lerDouble() {

        while (true) {

            try {
                double preco = Double.parseDouble(
                        JOptionPane.showInputDialog("Digite o PREÇO do produto: ")
                                .replace(",", ".")
                );

                if (preco <= 0) {
                    JOptionPane.showMessageDialog(null, "Digite um valor MAIOR que 0!");

                } else {
                    return preco;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Entrada inválida! Digite apenas números.");
            }
        }
    }
}
