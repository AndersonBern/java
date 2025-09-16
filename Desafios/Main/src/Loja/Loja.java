package Loja;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loja {
    public static void main(String[] args){

        Integer id = 3;
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Produto> estoque = new HashMap<>();
        estoque.put(1, new Produto("café", 1, 14.8));
        estoque.put(2, new Produto("coco", 3, 4.8));
        estoque.put(3, new Produto("bolo", 2, 5.7));

        Boolean cont = false;
        while(!cont){
            System.out.println("********************************************************************");
            System.out.println("[ 1 ] Adicionar Produto");
            System.out.println("[ 2 ] Vender Produto");
            System.out.println("[ 3 ] Repor Produto");
            System.out.println("[ 4 ] Listar Produtos");
            System.out.println("[ 5 ] Sair");

            System.out.print("Digite uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao){
                case "1":
                    id++;

                    System.out.print("Digite o NOME do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a QUANTIDADE do produto: ");
                    Integer quant = sc.nextInt();

                    System.out.print("Digite o PREÇO do produto: ");
                    Double preco = sc.nextDouble();

                    Produto produto = new Produto(nome, quant, preco);
                    estoque.put(id, produto);


                    System.out.println("Produto cadastrado ao estoque!");
                    break;

                case "2":
                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja VENDER ?");
                    for(Map.Entry<Integer, Produto> p : estoque.entrySet()){
                        System.out.println("[ " + p.getKey() + " ] " + p.getValue().getNome());
                    }

                    System.out.print("Digite uma opção: ");
                    String venda = sc.nextLine();

                    if(estoque.containsKey(Integer.valueOf(venda))){
                        System.out.print("Quantas unidades de [ " + estoque.get(Integer.valueOf(venda)).getNome() + " ] você deseja VENDER: ");
                        String unidade = sc.nextLine();

                        Integer novaQuant = estoque.get(Integer.valueOf(venda)).getQuant() - Integer.parseInt(unidade);
                        estoque.get(Integer.valueOf(venda)).setQuant(novaQuant);
                        System.out.println("Produto vendido com sucesso!");

                        if(novaQuant <= 0){
                            estoque.remove(Integer.valueOf(venda));
                        }
                    }
                    else{
                        System.out.println("Produto não encontrado!");
                    }

                    break;

                case "3":
                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja REPOR ?");
                    for(Map.Entry<Integer, Produto> p : estoque.entrySet()){
                        System.out.println("[ " + p.getKey() + " ] " + p.getValue().getNome());
                    }

                    System.out.print("Digite uma opção: ");
                    String reposicao = sc.nextLine();

                    if(estoque.containsKey(Integer.valueOf(reposicao))){

                        System.out.print("Quantas unidades de [ " + estoque.get(Integer.valueOf(reposicao)).getNome() + " ] você deseja REPOR: ");
                        String unidade = sc.nextLine();

                        Integer novaQuant = estoque.get(Integer.valueOf(reposicao)).getQuant() + Integer.parseInt(unidade);

                        estoque.get(Integer.valueOf(reposicao)).setQuant(novaQuant);
                        System.out.println("Reposição feita com sucesso!");
                    }
                    else{
                        System.out.println("Produto não encontrado!");
                    }

                    break;

                case "4":
                    System.out.println("*********************** Estoque de produtos *********************** ");
                    Double total = 0.0;

                    for(Map.Entry<Integer, Produto> p : estoque.entrySet()){

                        System.out.println("ID: " + p.getKey());
                        System.out.println("Produto: " + p.getValue().getNome());
                        System.out.println("Quantidade: " + p.getValue().getQuant());
                        System.out.println("Preço: " + p.getValue().getPreco() + " R$");
                        System.out.println("--------------------------------------------------------------------");

                        total +=  p.getValue().getPreco() * p.getValue().getQuant();
                    }

                    System.out.println(" Valor TOTAL do estoque: " + total + " R$");
                    break;

                case "5":
                    cont = true;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }

    }
}
