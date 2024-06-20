package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        // o método 'put' além de adicionar ele **ATUALIZA** o valor do atributo
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if (!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        } else {
            System.out.println("O conjuto MAP de AgendaContatos está vazio!");
        }
    }

    public void exibirContatos(){
        if (!agendaContatoMap.isEmpty()){
            System.out.println(agendaContatoMap);
        } else {
            System.out.println("O conjuto MAP de AgendaContatos está vazio!");
        }
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()){
            numeroPorNome = agendaContatoMap.get(nome);
            return numeroPorNome;
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Goku", 123456);
        agendaContatos.adicionarContato("Goku", 654321);
        agendaContatos.adicionarContato("Goku Kakarotto", 547894);
        agendaContatos.adicionarContato("Goku Dragon Ball", 658741);
        agendaContatos.adicionarContato("Vegeta", 986536);

        // o método 'put' além de adicionar ele **ATUALIZA** o valor do atributo
        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Vegeta");
        agendaContatos.exibirContatos();

        String nomePesquisa = "Goku Kakarotto";
        Integer numPesquisa = agendaContatos.pesquisarPorNome(nomePesquisa);
        System.out.println("O número de telefone de " + nomePesquisa + " é: " + numPesquisa);

        String nomeInexistente = "Piccolo";
        Integer numInexistente = agendaContatos.pesquisarPorNome(nomeInexistente);
        System.out.println("O número de telefone de " + nomeInexistente + " é: " + numInexistente);
    }
}