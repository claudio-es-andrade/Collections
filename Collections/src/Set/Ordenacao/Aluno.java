package Set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private Long matricula;
    private String nome;
    private double media;

    public Aluno() {  }

    public Aluno(Long matricula, String nome, double media) {
        this.matricula = matricula;
        this.nome = nome;
        this.media = media;
    }

    public Aluno(Long matricula){
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Aluno o) {
        return nome.compareToIgnoreCase(o.getNome());
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(getMatricula(), aluno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    @Override
    public String toString() {
        return "\n Aluno {\n" +
                "matricula =" + matricula +
                ", nome ='" + nome + '\'' +
                ", media =" + media +
                '}';
    }
}

class ComparaPorNome implements Comparator<Aluno> {

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return o1.getNome().compareToIgnoreCase( o2.getNome() );
    }
}

class ComparaPorNota implements Comparator<Aluno>{

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Double.compare( o1.getMedia() , o2.getMedia() );
    }
}

class ComparaPorMatricula implements Comparator<Aluno>{

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Long.compare( o1.getMatricula() , o2.getMatricula() );
    }
}