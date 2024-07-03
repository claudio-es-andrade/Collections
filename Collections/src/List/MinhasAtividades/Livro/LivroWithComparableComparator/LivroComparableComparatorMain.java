package List.MinhasAtividades.Livro.LivroWithComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class LivroComparableComparatorMain {

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        ArrayList<LivroComparableComparator> livros = new ArrayList<LivroComparableComparator>() {
            {
                add(new LivroComparableComparator("Java - Guia do Programador: Atualizado Para Java 16", "Peter Jandl Junior", 2021));
                add(new LivroComparableComparator("Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java",
                        "Raoul-Gabriel Urma e  Richard Warburton", 2021));
                add(new LivroComparableComparator(
                        "Microsserviços Prontos Para a Produção: Construindo Sistemas Padronizados em uma Organização de Engenharia de Software",
                        "Susan J. Fowler", 2017));
                add(new LivroComparableComparator("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos",
                        "Aditya Y. Bhargava", 2017));
                add(new LivroComparableComparator("Kotlin em Ação", "Dmitry Jemerov e Svetlana Isakova", 2017));
            }
        };


        System.out.println("Livros após a ordenação natural (Título): ");
        Collections.sort(livros);
        for (LivroComparableComparator livro : livros) {
            System.out.println(livro.getTitulo() + " - " +
                    livro.getAutor() + " - " +
                    livro.getAnoPublicacao());
        }

        System.out.println("---------------------------------------");

        System.out.println("Livros após a ordenação por ano: ");
        Collections.sort(livros, new ComparaPorAno());
        for (LivroComparableComparator livro : livros) {
            System.out.println(livro.getAnoPublicacao() + " - " +
                    livro.getTitulo() + " - " +
                    livro.getAutor());
        }

        System.out.println("---------------------------------------");

        System.out.println("Livros após a ordenação por Titulo: ");
        Collections.sort(livros);
        for (LivroComparableComparator livro : livros) {
            System.out.println(livro.getAutor() + " - " +
                    livro.getTitulo() + " - " +
                    livro.getAnoPublicacao());
        }

        System.out.println("---------------------------------------");

        System.out.println("Livros após a ordenação por ano, autor e título: ");
        Collections.sort(livros, new CompararAnoAutorTitulo() );
        for (LivroComparableComparator livro : livros) {
            System.out.println(livro.getAnoPublicacao() + " - " +
                    livro.getAutor() + " - " +
                    livro.getTitulo());
        }
    }

}
