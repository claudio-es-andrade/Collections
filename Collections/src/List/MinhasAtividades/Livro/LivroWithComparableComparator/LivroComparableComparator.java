package List.MinhasAtividades.Livro.LivroWithComparableComparator;

import java.util.Comparator;
import java.util.Objects;

public class LivroComparableComparator implements Comparable<LivroComparableComparator>{
    //atributos
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public LivroComparableComparator(){  }

    public LivroComparableComparator(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Compara Livro por Titulo
    @Override
    public int compareTo(LivroComparableComparator o) {
        return titulo.compareTo(o.titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroComparableComparator livro = (LivroComparableComparator) o;
        return getAnoPublicacao() == livro.getAnoPublicacao() && Objects.equals(getTitulo(), livro.getTitulo()) && Objects.equals(getAutor(), livro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor(), getAnoPublicacao());
    }

    @Override
    public String toString() {
        return "Livro {\n " +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}

// Classe para comparar Livro por ano de publicação
class ComparaPorAno implements Comparator <LivroComparableComparator> {

    @Override
    public int compare(LivroComparableComparator o1, LivroComparableComparator o2) {
        return Integer.compare( o1.getAnoPublicacao(), o2.getAnoPublicacao() );
    }
}

// Classe para comparar Livro por Autor
class ComparaPorTitulo implements Comparator<LivroComparableComparator> {

    @Override
    public int compare(LivroComparableComparator l1, LivroComparableComparator l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}

class CompararAnoAutorTitulo implements Comparator<LivroComparableComparator> {
    @Override
    public int compare(LivroComparableComparator l1, LivroComparableComparator l2) {
        int ano = Integer.compare(l1.getAnoPublicacao(), l2.getAnoPublicacao());
        if (ano != 0)
            return ano;
        int autor = l1.getAutor().compareTo(l2.getAutor());
        if (autor != 0)
            return autor;
        return l1.getTitulo().compareTo(l2.getTitulo());
    }
}