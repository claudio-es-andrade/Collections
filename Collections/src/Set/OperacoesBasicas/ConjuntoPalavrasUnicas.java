package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> palavras;

    public ConjuntoPalavrasUnicas(){
        this.palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavras.add(palavra);
    }

    public void removerPalavra(String palavra){
        if( !palavras.isEmpty()){
            if(palavras.contains(palavra)){

                palavras.remove(palavra);
            }else{
                System.out.println("A palavra não foi encontrada no Conjunto.");
            }
        }else{
            System.out.println("O conjunto está vazio.");
        }
    }

    public void verificarPalavra(String palavra){
        if (palavras.contains(palavra)  )
            System.out.println(" Palavra: " + palavra + " está inserida no Conjunto de Palavras");
        else
            System.out.println(" Palavra: " + palavra + " NÃO está inserida no Conjunto de Palavras");
    }

    public void exibirPalavrasUnicas(){
        if ( !palavras.isEmpty() ){
            System.out.println(palavras);
        }else{
            System.out.println(" O conjunto de palvras está vazio");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " );
        conjuntoLinguagens.verificarPalavra("Java");
        System.out.println("A linguagem 'Python' está no conjunto? " );
        conjuntoLinguagens.verificarPalavra("Python");

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();
    }

}
