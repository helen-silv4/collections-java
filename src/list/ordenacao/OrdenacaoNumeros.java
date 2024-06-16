package list.ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numerosList.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosDescendentes = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()){
            numerosDescendentes.sort(Collections.reverseOrder());
            return numerosDescendentes;
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
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(1);
        numeros.adicionarNumero(7);
        numeros.adicionarNumero(24);
        numeros.adicionarNumero(78);
        numeros.adicionarNumero(0);

        numeros.exibirNumeros();

        System.out.print("Ordem ascendente: " + numeros.ordenarAscendente());
        System.out.print("\nOrdem descendente: " + numeros.ordenarDescendente());
    }
}