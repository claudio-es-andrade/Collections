package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    Map<String, Integer> armazenaPalavras;

    public ContagemPalavras() {
        this.armazenaPalavras = new HashMap<>();
    }

    public ContagemPalavras(Map<String, Integer> armazenaPalavras) {
        this.armazenaPalavras = armazenaPalavras;
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        armazenaPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!armazenaPalavras.isEmpty()){
            armazenaPalavras.remove(palavra);
        }
        else {
            System.out.println("Não há palavras.");
        }
    }

    public int exibirContagemPalavras(){
        int contagemTotal = 0;
        for(int contagem : armazenaPalavras.values() ){
            contagemTotal += contagem;
        }
        return contagemTotal;

    }

    public String   encontrarPalavraMaisFrequente(){
        String linguagemMaisFrequente = null;
        int maisFrequente = 0;
        for ( Map.Entry<String,Integer> entry : armazenaPalavras.entrySet() ) {
            if (entry.getValue() > maisFrequente ) {
                maisFrequente = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        return linguagemMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);
        contagemLinguagens.adicionarPalavras("Rust", 13);
        contagemLinguagens.adicionarPalavras("Html", 7);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        // Remove uma palavra
        contagemLinguagens.removerPalavra("Html");
        System.out.println(" Palavra Removida: Html" );

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }


}
