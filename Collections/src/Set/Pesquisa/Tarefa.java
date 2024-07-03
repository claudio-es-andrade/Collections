package Set.Pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa() {
    }

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public Tarefa(String descricao, boolean concluida) {
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return isConcluida() == tarefa.isConcluida() && Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao(), isConcluida());
    }

    @Override
    public String toString() {
        return "Tarefa{ \n" +
                " Descricao = " + descricao + "\n" +
                " Concluida = " + concluida +
                "\n } \n" ;
    }
}
