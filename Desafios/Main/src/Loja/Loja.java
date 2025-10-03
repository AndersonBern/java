package Loja;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Loja {

    private static final int OPCAO_ADICIONAR = 1;
    private static final int OPCAO_VENDER = 2;
    private static final int OPCAO_REPOR = 3;
    private static final int OPCAO_ESTOQUE = 4;
    private static final int OPCAO_SALVAR = 5;

    static final Estoque estoque = new Estoque();
    static Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, Produto> produtos;
    private static Persistencia persistencia;

    private static final String MSG_VENDA_SUCESSO = "Produto VENDIDO com sucesso!";
    private static final String MSG_VENDA_FALHA = "Venda não concluida! Estoque INSUFICIENTE ou produto não ENCONTRADO!";
    private static final String MSG_REPOR_SUCESSO = "Produto REPOSTO com sucesso!";
    private static final String MSG_REPOR_FALHA = "Reposição não concluida! QUANTIDADE inválida ou produto não ENCONTRADO!";
    private static final String MSG_OPCAO = "Digite uma opção: ";

    public static void main(String[] args){

        persistencia = new Persistencia(null, "produtos.json"); // cria persistencia com caminho
        LinkedHashMap<Integer, Produto> produtosCarregados = persistencia.carregar(); // lê do arquivo

        estoque.setProdutos(produtosCarregados);

        produtos = estoque.getProdutos();

        boolean executando = true;
        while (executando) {

            mostrarMenu();

            System.out.print(MSG_OPCAO);
            int opcao = 0;

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
            }


            switch (opcao) {

                case OPCAO_ADICIONAR:
                    System.out.print("Digite o NOME do produto: ");
                    String nome = sc.nextLine();

                    int quantidade = Leitura.lerInteiro(sc, "Digite a QUANTIDADE do produto: ");

                    double preco = Leitura.lerDouble(sc, "Digite o PREÇO do produto: ");

                    Produto novo = estoque.adicionar(nome, quantidade, preco);
                    System.out.println("Produto: " + novo.getNome() + " foi adicionado ao estoque!");

                    break;

                case OPCAO_VENDER:

                    auxiliar("vender");
                    persistencia.salvar();
                    break;

                case OPCAO_REPOR:

                    auxiliar("repor");
                    break;

                case OPCAO_ESTOQUE:
                    System.out.println("*********************** Estoque de produtos *********************** ");

                    listarProdutos(false);

                    break;

                case OPCAO_SALVAR:

                    estoque.adicionar("café", 1, 15.9);
                    estoque.adicionar("bolo", 2, 6.9);
                    estoque.adicionar("ovo", 3, 13.8);

                    produtos = estoque.getProdutos();

                    persistencia = new Persistencia(produtos, "produtos.json");
                    persistencia.salvar();

                    executando = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");

            }

        }
        sc.close();
    }

    public static void mostrarMenu() {
        separador();
        System.out.println("[ 1 ] Adicionar Produto");
        System.out.println("[ 2 ] Vender Produto");
        System.out.println("[ 3 ] Repor Produto");
        System.out.println("[ 4 ] Listar Produtos");
        System.out.println("[ 5 ] SALVAR alterações");
    }

    public static void listarProdutos(boolean resumo) {

        estoque.getProdutos().forEach((id, produto) -> {

            if (resumo) {
                //Só id e nome
                System.out.println("[ " + id + " ] " + produto.getNome());
            } else {
                //Mostra produto com mais detalhes
                System.out.println("ID: " + id);
                System.out.println(produto);
                System.out.println("--------------------------------------------------------------------");
            }

        });

        if (!resumo) {
            //Calcula TOTAL(Somente na lista detalhada)
            double total = estoque.getProdutos().values()
                    .stream()
                    .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                    .sum();

            System.out.println(" Valor TOTAL do estoque: " + String.format("%.2f", total) + " R$");
        }
    }

    private static void separador() {
        System.out.println("********************************************************************");
    }

    private static void auxiliar(String acao) {

        separador();
        System.out.println("Qual produto você deseja " + acao.toUpperCase() + " ?");

        listarProdutos(true);

        int id = Leitura.lerInteiro(sc, MSG_OPCAO);

        int unidade = Leitura.lerInteiro(sc, "Quantas unidades você deseja " + acao.toUpperCase() + ": ");

        boolean sucesso;

        switch (acao.toLowerCase()){

            case "vender":
                sucesso = estoque.venderProduto(id, unidade);

                System.out.println(sucesso ? MSG_VENDA_SUCESSO : MSG_VENDA_FALHA);
                break;

            case "repor":
                sucesso = estoque.reporProduto(id, unidade);

                System.out.println(sucesso ? MSG_REPOR_SUCESSO : MSG_REPOR_FALHA);
                break;

            default:
                System.out.println("Ação inválida!");
                break;
        }

    }
}
