package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> DicionarioMap;

    public Dicionario(){ this.DicionarioMap = new HashMap<>();  }

    public void adicionarPalavra(String palavra, String definicao){
        DicionarioMap.put(palavra, definicao);

    }

    public void removerPalavra(String palavra){
        if(!DicionarioMap.isEmpty()){
            DicionarioMap.remove(palavra);
        }else
            System.out.println("O Dicionário está sem palavras.");

    }

    public void exibirPalavras(){
        if(!DicionarioMap.isEmpty()){
            System.out.println(DicionarioMap);
        }else
            System.out.println("Acrescente palavras ao Dicionário.");
    }

    public String pesquisarPorPalavra(String palavra){
        String definicao = null;
        if (!DicionarioMap.isEmpty()) {
            definicao = DicionarioMap.get(palavra);
            if (definicao == null) {
                System.out.println("A palavra fornecida não possui definição no Dicionário.");
            }
        } else {
            System.out.println("O Dicionário está vazio.");
        }
        return definicao;

    }

    public static void main(String[] args) {
        Dicionario meuDicionario = new Dicionario();

        // Adicionando palavras e descricoes:
        meuDicionario.adicionarPalavra("carro", "veículo" );
        meuDicionario.adicionarPalavra("chave", "objeto usado para abrir portas, cofres em geral" );
        meuDicionario.adicionarPalavra("manga", "fruta" );
        meuDicionario.adicionarPalavra("amendoeira", "espécie de árvore" );

        // Exibir as palavras e definicoes.
        meuDicionario.exibirPalavras();

        // Remover um contato
        System.out.println("Removendo uma palavra");
        meuDicionario.removerPalavra("carro");
        meuDicionario.exibirPalavras();

        // Pesquisar por palavra
        String palavraProcurada = "chave";
        String definicaoProcurada = meuDicionario.pesquisarPorPalavra("chave");
        System.out.println("A definição de " + palavraProcurada + " é: " + definicaoProcurada);
        // Pesquisar por palavra
        String palavraProcurada2 = "molho";
        String definicaoProcurada2 = meuDicionario.pesquisarPorPalavra("molho");
        System.out.println("A definição de " + palavraProcurada2 + " é: " + definicaoProcurada2);




    }

}
