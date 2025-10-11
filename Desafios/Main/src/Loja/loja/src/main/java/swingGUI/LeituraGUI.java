package swingGUI;

import javax.swing.*;

public class LeituraGUI {

    public static String lerString(JFrame frame) {

        while (true){

            String nome = JOptionPane.showInputDialog(frame, "Digite o NOME do produto: ");

            if(nome == null || nome.trim().isEmpty() || nome.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(frame, "Digite um nome válido!");
            }
            else{
                return nome;
            }
        }
    }

    public static int lerInteiro(String mensagem, JFrame frame) {

        while (true) {

            try {
                int quantidade = Integer.parseInt(
                        JOptionPane.showInputDialog(frame, mensagem)
                );

                if(quantidade <= 0){
                    JOptionPane.showMessageDialog(frame, "Digite um numero MAIOR que 0.");
                }else {
                    return quantidade;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame,
                        "Entrada inválida! Digite apenas números INTEIROS.");
            }
        }
    }

    public static double lerDouble(JFrame frame) {

        while (true) {

            try {
                double preco = Double.parseDouble(
                        JOptionPane.showInputDialog(frame,"Digite o PREÇO do produto: ")
                                .replace(",", ".")
                );

                if (preco <= 0) {
                    JOptionPane.showMessageDialog(frame, "Digite um valor MAIOR que 0!");

                } else {
                    return preco;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame,
                        "Entrada inválida! Digite apenas números.");
            }
        }
    }
}
