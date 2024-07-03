package List.MinhasAtividades.Compra.CompraWithComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class ItensComparados {


    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        Item item01 = new Item("pao", 3d, 6);
        Item item02 = new Item("pao", 7d, 12);
        Item item03 = new Item("leite", 6d, 2);
        Item item04 = new Item("leite", 4d, 4);
        Item item05 = new Item("caviar", 20d, 5);
        Item item06 = new Item("caviar", 40d, 9);
        Item item07 = new Item("caviar", 60d, 10);
        Item item08 = new Item("caviar", 80d, 12);
        Item item09 = new Item("pao", 5d, 5);
        Item item10 = new Item("pao", 2d, 3);
        Item item11 = new Item("leite", 7d, 3);
        Item item12 = new Item("leite", 5d, 5);
        Item item13 = new Item("queijo", 25d, 1);
        Item item14 = new Item("manteiga", 35, 2);
        Item item15 = new Item("queijo", 35d, 2);

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item01);
        itens.add(item02);
        itens.add(item03);
        itens.add(item04);
        itens.add(item05);
        itens.add(item06);
        itens.add(item07);
        itens.add(item08);
        itens.add(item09);
        itens.add(item10);
        itens.add(item11);
        itens.add(item12);
        itens.add(item13);
        itens.add(item14);
        itens.add(item15);


        CompararQuantidade compararQuantidade = new CompararQuantidade();
        CompararPreco compararPreco = new CompararPreco();

        // Compara item por NomeQuantidade
        System.out.println("Itens com as menores Quantidades (ascendente)");
        Collections.sort(itens , compararQuantidade);
        for(Item itemT : itens){
            System.out.println(itemT);
        }

        System.out.println("Itens com os menores Preços");

        Collections.sort(itens , compararPreco);
        for(Item itemT : itens){
            System.out.println(itemT);
        }

        // Definido como método na Classe Item
        System.out.println("Comparar por Nome");

        Collections.sort(itens);
        for(Item itemT : itens){
            System.out.println(itemT);
        }


    }
}
