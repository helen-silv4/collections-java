package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numerosList;

    public SomaNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numerosList.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for (Integer num : numerosList){
            soma += num;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNum = Integer.MIN_VALUE;
        if (!numerosList.isEmpty()){
            for (Integer num : numerosList){
                if(num >= maiorNum){
                    maiorNum = num;
                }
            }
            return maiorNum;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMenorNumero(){
        int menorNum = Integer.MAX_VALUE;
        if (!numerosList.isEmpty()){
            for (Integer num : numerosList){
                if (num <= menorNum){
                    menorNum = num;
                }
            }
            return menorNum;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros(){
        if (!numerosList.isEmpty()){
            System.out.println(numerosList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(-10);
        somaNumeros.adicionarNumero(7);
        somaNumeros.adicionarNumero(1);

        System.out.print("Números adicionados na lista: ");
        somaNumeros.exibirNumeros();

        System.out.println("Soma: " + somaNumeros.calcularSoma());

        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());
    }
}