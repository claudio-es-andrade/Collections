package Map.Ordenacao;

import java.util.Objects;
import java.util.Comparator;
import java.util.Map;

public class Livro {

    private String titulo;
    private String autor;
    private double preco;

    public Livro() {  }

    public Livro(String titulo) {
        this.titulo = titulo;
//        this.autor = autor;
//        this.preco = preco;
    }
    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return Objects.equals(getTitulo(), livro.getTitulo()) && Objects.equals(getAutor(), livro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor());
    }

    @Override
    public String toString() {
        return "\n Livro { \n " +
                " Titulo = '" + titulo + '\'' +
                ", Autor = '" + autor + '\'' +
                ", Preço = " + preco +
                '}';
    }
}
class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
    }
}

class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getAutor().compareToIgnoreCase(l2.getValue().getAutor());
    }
}