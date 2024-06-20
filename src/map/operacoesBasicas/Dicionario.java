package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);

    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        } else {
            System.out.println("O conjunto MAP de dicionário está vazio!");
        }
    }

    public void exibirPalavras(){
        if (!dicionarioMap.isEmpty()){
            System.out.println(dicionarioMap);
        } else {
            System.out.println("O conjunto MAP de dicionário está vazio!");
        }
    }

    public String pesquisarPorPalavra(String palavra){
        String definicaoPorPalavra = dicionarioMap.get(palavra);
        if (definicaoPorPalavra != null){
            return definicaoPorPalavra;
        } else {
            return "Palavra não encontrada no dicionário!";
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.exibirPalavras();

        dicionario.adicionarPalavra("Main", "Principal");
        dicionario.adicionarPalavra("JDK", "Kit de Desenvolvimento Java");
        dicionario.adicionarPalavra("JVM", "Máquina Virtual Java");
        dicionario.adicionarPalavra("JDK", "Java Development Kit ");

        // o método 'put' além de adicionar ele **ATUALIZA** o valor do atributo
        dicionario.exibirPalavras();

        dicionario.removerPalavra("Main");

        dicionario.exibirPalavras();

        String palavraPesquisa = "JVM";
        String definicaoPalavra = dicionario.pesquisarPorPalavra(palavraPesquisa);
        System.out.println("Definição da palavra " + palavraPesquisa + " é: " + definicaoPalavra);

        String palavraInexistente = "IDE";
        String definicaoInexistente = dicionario.pesquisarPorPalavra(palavraInexistente);
        System.out.println("Definição da palavra " + palavraInexistente + " é: " + definicaoInexistente);

        System.out.println(dicionario.pesquisarPorPalavra(null));
    }
}