package List.MinhasAtividades.Compra;

import java.util.Objects;

public class Item {
    private String nome;
    private double preco;
    private int quantidade;

    public Item() {  }

    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(getPreco(), item.getPreco()) == 0 && getQuantidade() == item.getQuantidade() && Objects.equals(getNome(), item.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPreco(), getQuantidade());
    }

    @Override
    public String toString() {
        return "Item{\n" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
