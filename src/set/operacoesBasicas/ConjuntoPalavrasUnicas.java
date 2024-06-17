package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        if (!palavrasUnicasSet.isEmpty()){
            if (palavrasUnicasSet.contains(palavra)){
                palavrasUnicasSet.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto!");
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public boolean verificarPalavra(String palavra){
        return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if (!palavrasUnicasSet.isEmpty()){
            System.out.println(palavrasUnicasSet);
        } else {
            System.out.println("O conjuto está vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoConvidados = new ConjuntoPalavrasUnicas();

        conjuntoConvidados.adicionarPalavra("Java");
        conjuntoConvidados.adicionarPalavra("C#");
        conjuntoConvidados.adicionarPalavra("C++");
        conjuntoConvidados.adicionarPalavra("Python");
        conjuntoConvidados.adicionarPalavra("Kotlin");
        conjuntoConvidados.adicionarPalavra("JavaScript");

        conjuntoConvidados.exibirPalavrasUnicas();

        conjuntoConvidados.removerPalavra("Kotlin");
        conjuntoConvidados.exibirPalavrasUnicas();

        conjuntoConvidados.removerPalavra("Swift");

        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoConvidados.verificarPalavra("Java"));
        System.out.println("A linguagem 'Ruby' está no conjunto? " + conjuntoConvidados.verificarPalavra("Ruby"));
    }
}