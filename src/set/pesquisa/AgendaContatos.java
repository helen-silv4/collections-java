package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet){
            if(c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public int contarContatos(){
        return contatoSet.size();
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();
        System.out.println("Número de contatos: " + agendaContatos.contarContatos());

        agendaContatos.adicionarConvidado("Goku", 123456);
        agendaContatos.adicionarConvidado("Goku", 654321);
        agendaContatos.adicionarConvidado("Goku Kakarotto", 547894);
        agendaContatos.adicionarConvidado("Goku Dragon Ball", 658741);
        agendaContatos.adicionarConvidado("Vegeta", 986536);

        agendaContatos.exibirContatos();
        System.out.println("Número de contatos: " + agendaContatos.contarContatos());

        System.out.println(agendaContatos.pesquisarPorNome("Vegeta"));
        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Vegeta", 111111));

        agendaContatos.exibirContatos();
    }
}