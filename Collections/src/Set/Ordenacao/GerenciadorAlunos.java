package Set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class GerenciadorAlunos {
    Set<Aluno> alunos;
    public GerenciadorAlunos() {
        this.alunos = new HashSet<>();
    }
    public void adicionarAluno(Long matricula, String nome, double media){

        alunos.add( new Aluno(matricula, nome, media) );
    }

    public void removerAluno(long matricula){

        Aluno alunoParaRemover = null;
        if( !alunos.isEmpty() ){
            for (Aluno aluno : alunos){
                if (aluno.getMatricula() == matricula){
                    alunoParaRemover = aluno;
                    break;
                }
            }
            alunos.remove(alunoParaRemover);
        }
        else {
            throw new RuntimeException("Conjunto vazio!");
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }

    }

    public Set<Aluno> exibirAlunosPorNome(){

        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
        if (!alunos.isEmpty()) {
            alunosPorNome.addAll(alunos);
            System.out.println("Listagem dos Alunos (Ordem Alfabética) ");
            return alunosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparaPorNota());
        if (!alunos.isEmpty()) {
            alunosPorNota.addAll(alunos);
            System.out.println("Listagem dos Alunos por Notas (Ordem Crescente)");
            return alunosPorNota;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunos() {
        Set<Aluno> alunosPorMatricula = new TreeSet<>(new ComparaPorMatricula() );
        if (!alunos.isEmpty()) {
            alunosPorMatricula.addAll(alunos);
            System.out.println("Listagem dos Alunos (Matrícula)");
            return alunosPorMatricula;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno(123456L, "João",  7.5);
        gerenciadorAlunos.adicionarAluno(123457L, "Maria", 9.0);
        gerenciadorAlunos.adicionarAluno(123458L,"Carlos", 5.0);
        gerenciadorAlunos.adicionarAluno(123459L,"Ana", 6.8);
        gerenciadorAlunos.adicionarAluno(125759L,"Helena", 6.8);
        gerenciadorAlunos.adicionarAluno(124959L,"Tobias", 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunos);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println(gerenciadorAlunos.alunos);

        // Exibindo alunos ordenados por nome
        Set<Aluno> alunosPorNome = gerenciadorAlunos.exibirAlunosPorNome();
        System.out.println(alunosPorNome);

        // Exibindo alunos ordenados por nota
        Set<Aluno> alunosPorNota = gerenciadorAlunos.exibirAlunosPorNota();
        System.out.println(alunosPorNota);

        // Exibindo alunos ordenados por matricula
        Set<Aluno> alunosPorMatricula = gerenciadorAlunos.exibirAlunos();
        System.out.println(alunosPorMatricula);
    }

}
