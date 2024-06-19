package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricaoTarefa().equalsIgnoreCase(descricao)){
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto SET está vazio!");
        }

        if (tarefaParaRemover == null){
            System.out.println("Tarefa não encontrada na lista!");
        }
    }

    public void exibirTarefas(){
        if (!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        } else {
            System.out.println("O conjunto SET está vazio!");
        }
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (t.isStatus()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (!t.isStatus()){
                tarefasPendentes.add(t);
            }
        }
        return  tarefasPendentes;
    }

    public Tarefa marcarTarefaConcluida(String descricao){
        Tarefa tarefaConcluida = null;
        for (Tarefa t : tarefaSet){
            if (t.getDescricaoTarefa().equalsIgnoreCase(descricao)){
                t.setStatus(true);
                tarefaConcluida = t;
                break;
            }
        }

        if (tarefaConcluida != null) {
            if(!tarefaConcluida.isStatus()) {
                tarefaConcluida.setStatus(true);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista!");
        }

        return tarefaConcluida;
    }

    public Tarefa marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for (Tarefa t : tarefaSet){
            if (t.getDescricaoTarefa().equalsIgnoreCase(descricao)){
                t.setStatus(false);
                tarefaPendente = t;
                break;
            }
        }

        if (tarefaPendente != null) {
            if(tarefaPendente.isStatus()) {
                tarefaPendente.setStatus(false);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista!");
        }

        return tarefaPendente;
    }

    public void limparListaTarefas(){
        if (tarefaSet.isEmpty()){
            System.out.println("A lista SET já está vazia!");
        } else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 4");

        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Tarefa 4");
        listaTarefas.removerTarefa(null);
        listaTarefas.exibirTarefas();

        System.out.println("Número de tarefas: " + listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("Tarefa 1");
        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        System.out.println("Tarefas concluidas: " + listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Tarefa 2");
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaPendente("Tarefa 8");
        listaTarefas.marcarTarefaConcluida("Tarefa 10");

        System.out.println("Número de tarefas: " + listaTarefas.contarTarefas());
    }
}