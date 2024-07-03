package List.MinhasAtividades.Compra;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    List<Item> compras;

    public CarrinhoDeCompras() {
        this.compras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        compras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();
        if (!compras.isEmpty()) {
            for (Item t : compras) {
                if (t.getNome().equalsIgnoreCase(nome)) {
                    itemsParaRemover.add(t);
                }
            }
            compras.removeAll(itemsParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calculaValorTotal() {
        double valorTotal = 0d;
        for (Item t: compras){
            valorTotal += (t.getPreco() * t.getQuantidade() );
        }
        return valorTotal;
    }

    public void exibirItens() {
        if (!compras.isEmpty()) {
            System.out.println(compras);
        } else {
            System.out.println("O carrinho está vazio.");
        }
    }
    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + compras +
                '}';
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("pao", 3d, 5);
        carrinhoDeCompras.adicionarItem("leite", 6d, 2);
        carrinhoDeCompras.adicionarItem("queijo", 25d, 1);
        carrinhoDeCompras.adicionarItem("manteiga", 35, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("manteiga");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calculaValorTotal());
    }


}
