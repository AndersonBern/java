package Loja;

import java.util.Scanner;

public class Loja {

    private static final int OPCAO_ADICIONAR = 1;
    private static final int OPCAO_VENDER   = 2;
    private static final int OPCAO_REPOR    = 3;
    private static final int OPCAO_ESTOQUE = 4;
    private static final int OPCAO_SAIR     = 5;

    private static final Estoque estoque = new Estoque();

    public static void mostrarMenu(){
        System.out.println("********************************************************************");
        System.out.println("[ 1 ] Adicionar Produto");
        System.out.println("[ 2 ] Vender Produto");
        System.out.println("[ 3 ] Repor Produto");
        System.out.println("[ 4 ] Listar Produtos");
        System.out.println("[ 5 ] Sair");
    }

    public static void listarProdutos(boolean resumo){

        estoque.getProdutos().forEach((id, produto) -> {

            if(resumo){
                //Só id e nome
                System.out.println("[ " + id + " ] " + produto.getNome());
            }
            else{
                //Mostra produto com mais detalhes
                System.out.println("ID: " + id);
                System.out.println(produto);
                System.out.println("--------------------------------------------------------------------");
            }

        });

        if(!resumo){
            //Calcula TOTAL(Somente na lista detalhada)
            double total = estoque.getProdutos().values()
                    .stream()
                    .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                    .sum();

            System.out.println(" Valor TOTAL do estoque: " + String.format("%.2f", total) + " R$");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        estoque.adicionar("café", 1, 14.8);
        estoque.adicionar("coco", 3, 4.8);
        estoque.adicionar("bolo", 2, 5.7);

        boolean executando = true;
        while(executando){

            mostrarMenu();

            System.out.print("Digite uma opção: ");
            int opcao = 0;

            try{
                opcao = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
            }


            switch (opcao){

                case OPCAO_ADICIONAR:
                    System.out.print("Digite o NOME do produto: ");
                    String nome = sc.nextLine();

                    int quantidade = Leitura.lerInteiro(sc, "Digite a QUANTIDADE do produto: ");

                    double preco = Leitura.lerDouble(sc, "Digite o PREÇO do produto: ");

                    Produto novo = estoque.adicionar(nome, quantidade, preco);
                    System.out.println("Produto: " + novo.getNome() + " foi adicionado ao estoque!");
                    break;

                case OPCAO_VENDER:

                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja VENDER ?");

                    listarProdutos(true);

                    int id = Leitura.lerInteiro(sc, "Digite uma opção: ");

                    int unidade = Leitura.lerInteiro(sc, "Quantas unidades você deseja VENDER: ");

                    boolean sucesso = estoque.venderProduto(id, unidade);

                    if (sucesso){
                        System.out.println("Produto vendido com sucesso!");
                    }
                    else{
                        System.out.println("Venda não concluida! Estoque INSUFICIENTE ou produto não ENCONTRADO!");
                    }
                    break;

                case OPCAO_REPOR:
                    System.out.println("********************************************************************");
                    System.out.println("Qual produto você deseja REPOR ?");

                    listarProdutos(true);

                    int reposicao = Leitura.lerInteiro(sc, "Digite uma opção: ");

                    int unidades = Leitura.lerInteiro(sc, "Quantas unidades você deseja REPOR: ");

                    boolean sucess = estoque.reporProduto(reposicao, unidades);

                    if (sucess){
                        System.out.println("Produto REPOSTO com sucesso!");
                    }
                    else{
                        System.out.println("Reposição não concluida! QUANTIDADE inválida ou produto não ENCONTRADO!");
                    }

                    break;

                case OPCAO_ESTOQUE:
                    System.out.println("*********************** Estoque de produtos *********************** ");

                    listarProdutos(false);

                    break;

                case OPCAO_SAIR:
                    executando = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }
        sc.close();
    }

}
