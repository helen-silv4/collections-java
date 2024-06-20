package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno alunoParaRemover = null;
        if (!alunoSet.isEmpty()){
            for (Aluno a : alunoSet){
                if (a.getMatricula() == matricula){
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto SET de alunos está vazio!");
        }

        if (alunoParaRemover == null){
            System.out.println("Matrícula não encontrada!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if (!alunoSet.isEmpty()){
            return alunosPorNome;
        } else {
            throw new RuntimeException("O conjunto SET de alunos está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorMedia(){
        Set<Aluno> alunosPorMedia = new TreeSet<>(new ComparatorPorMedia());
        if (!alunoSet.isEmpty()){
            alunosPorMedia.addAll(alunoSet);
            return alunosPorMedia;
        } else {
            throw new RuntimeException("O conjunto SET de alunos está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorMatricula(){
        Set<Aluno> alunosPorMatricula = new TreeSet<>(new ComparatorPorMatricula());
        if (!alunoSet.isEmpty()) {
            alunosPorMatricula.addAll(alunoSet);
            return alunosPorMatricula;
        } else {
            throw new RuntimeException("O conjunto SET de alunos está vazio!");
        }
    }

    public void exibirAlunos(){
        if (!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        } else {
            System.out.println("O conjunto SET de alunos está vazio!");
        }
    }

    public int totalAlunos(){
        return alunoSet.size();
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.adicionarAluno("Aluno 1", 7895L, 10d);
        gerenciadorAlunos.adicionarAluno("Aluno 5", 1234L, 9d);
        gerenciadorAlunos.adicionarAluno("Aluno 7", 7895L, 0d);
        gerenciadorAlunos.adicionarAluno("Aluno 8", 9874L, 2d);
        gerenciadorAlunos.adicionarAluno("Aluno 2", 5698L, 7d);

        // obs: alunos que tem a mesma matrícula, não podem estar contido dentro do mesmo SET
        // 'Aluno 7' foi desconsiderado por ter a mesma matrícula
        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorMedia());
        System.out.println(gerenciadorAlunos.exibirAlunosPorMatricula());

        System.out.println("Total alunos: " + gerenciadorAlunos.totalAlunos());

        gerenciadorAlunos.removerAluno(7895L);
        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno(4575L);

        System.out.println("Total alunos: " + gerenciadorAlunos.totalAlunos());
    }
}
