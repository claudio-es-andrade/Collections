package Set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    Set<Produto> produtos;

    public CadastroProdutos(){
        this.produtos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        Produto produtoAdd = new Produto( cod, nome, preco, quantidade);
        produtos.add(produtoAdd);
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtos);
        if (!produtos.isEmpty()) {
            produtosPorNome.addAll(produtos);
            System.out.println("Lista de Produtos por Ordem Alfabética");
            return produtosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }

    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparaPorPreco());
        if (!produtos.isEmpty()) {
            produtosPorPreco.addAll(produtos);
            System.out.println("Lista de Produtos por Preços");
            return produtosPorPreco;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorQuantidade() {
        Set<Produto> produtosPorQuantidade = new TreeSet<>(new ComparaPorQuantidade() );
        if (!produtos.isEmpty()) {
            produtosPorQuantidade.addAll(produtos);
            System.out.println("Lista de Produtos por Quantidade");
            return produtosPorQuantidade;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorCodigo() {
        Set<Produto> produtosPorCodigo = new TreeSet<>(new ComparaPorCodigo() );
        if (!produtos.isEmpty()) {
            produtosPorCodigo.addAll(produtos);
            System.out.println("Lista de Produtos por Código");
            return produtosPorCodigo;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println( cadastroProdutos.produtos );

        // Exibindo produtos ordenados por nome
        Set<Produto> produtosPorNome = cadastroProdutos.exibirProdutosPorNome();
        System.out.println( produtosPorNome );

        // Exibindo produtos ordenados por preço
        Set<Produto> produtosPorPreco = cadastroProdutos.exibirProdutosPorPreco();
        System.out.println( produtosPorPreco );

        // Exibindo produtos ordenados por quantidade
        Set<Produto> produtosPorQuantidade = cadastroProdutos.exibirProdutosPorQuantidade();
        System.out.println( produtosPorQuantidade );

        // Exibindo produtos ordenados por código
        Set<Produto> produtosPorCodigo = cadastroProdutos.exibirProdutosPorCodigo();
        System.out.println( produtosPorCodigo );

    }

}
