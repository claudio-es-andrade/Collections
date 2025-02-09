package Set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private long cod;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(){ }

    public Produto(long cod, String nome, double preco, int quantidade) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto o) {
        return this.nome.compareToIgnoreCase( o.getNome() );
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCod() == produto.getCod();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod());
    }

    @Override
    public String toString() {
        return "\n Produto { \n " +
                "cod = " + cod +
                ", nome ='" + nome + '\'' +
                ", preco =" + preco +
                ", quantidade = " + quantidade +
                '}';
    }
}

class ComparaPorPreco implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return Double.compare( o1.getPreco(), o2.getPreco() );
    }
}

class ComparaPorQuantidade implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return Integer.compare( o1.getQuantidade(), o2.getQuantidade() );
    }
}

class ComparaPorCodigo implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return Long.compare( o1.getCod() , o2.getCod() );
    }
}