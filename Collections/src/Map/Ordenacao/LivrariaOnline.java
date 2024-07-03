package Map.Ordenacao;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LivrariaOnline {

    Map<String, Livro> livrarias;

    public LivrariaOnline(){
        this.livrarias = new HashMap<>();
    }

    @Override
    public String toString() {
        return "\n LivrariaOnline \n {" +
                "LIVROS : " + livrarias +
                '}';
    }

    public LivrariaOnline(Map<String, Livro> livrarias) {
        this.livrarias = livrarias;
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrarias.put(link, new Livro(titulo,autor,preco));
        //System.out.println(" Livro Online adicionado:" );
    }

    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : livrarias.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
            }
        }
        for (String chave : chavesRemover) {
            livrarias.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrarias.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrarias.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrarias.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)) {
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if (!livrarias.isEmpty()) {
            for (Livro livro : livrarias.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livrarias.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livrarias.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;

        if (!livrarias.isEmpty()) {
            for (Livro livro : livrarias.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livrarias.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo = livrarias.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo);
            }
        }
        return livrosMaisBaratos;
    }


    public static void main(String[] args) {

        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Programador-Pragm%C3%A1tico-Aprendiz-Mestre/dp/8577807002/", "O Programador Pragmático: De Aprendiz a Mestre", "Andrew Hunt", 178d);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Como-Ser-Um-Programador-Melhor/dp/8575224158/", "Como ser um programador melhor:", "Pete Goodliffe", 68.30d);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/C%C3%B3digo-Limpo-Robert-C-Martin-ebook/dp/B085Q2K632", "Código Limpo", "Robert C. Martin", 88.20d);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Refatora%C3%A7%C3%A3o-Aperfei%C3%A7oando-Design-C%C3%B3digos-Existentes/dp/8575227246", "Refatoração: Aperfeiçoando o Design de Códigos Existentes", "Martin Fowler", 109.65d);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Criando-Microsservi%C3%A7os-Projetando-Componentes-Especializados/dp/6586057884", "Criando Microsserviços: Projetando Sistemas com Componentes Menores e Mais Especializados", "Sam Newman", 134.14d);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Desenvolvimento-Real-Software-projetos-fundamentos/dp/6555202017", "Desenvolvimento Real de Software: um Guia de Projetos Para Fundamentos em Java", "Raoul-Gabriel Urma", 52.50d);

         // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        // Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Joshua Bloch";
        System.out.println("Pesquisa de Livros por autor: " + autorPesquisa);
        Map<String, Livro> livroPesquisadoPorAutor_01 = livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);
        System.out.println(livroPesquisadoPorAutor_01);
        System.out.println("Fim da pesquisa de Livros por autor: " + autorPesquisa);

        // Pesquisa livros por autor
        String autorPesquisa2 = "Robert C. Martin";
        System.out.println("Pesquisa de Livros por autor: " + autorPesquisa2);
        Map<String, Livro> livroPesquisadoPorAutor_02 = livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa2);
        System.out.println(livroPesquisadoPorAutor_02);
        System.out.println("Fim da pesquisa de Livros por autor: " + autorPesquisa2);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        System.out.println("Livro removido de acordo com a escolha: Como ser um programador melhor");
        livrariaOnline.removerLivro("Como ser um programador melhor:");
        System.out.println(livrariaOnline);
    }
}
