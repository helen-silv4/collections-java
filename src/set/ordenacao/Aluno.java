package set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private long matricula;
    private double media;

    public Aluno(String nome, long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.media = nota;
    }

    public String getNome() {
        return nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public double getMedia() {
        return media;
    }

    // oq diferencia um aluno do outro é sua matrícula
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return getMatricula() == aluno.getMatricula();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    // comparar por nome
    @Override
    public int compareTo(Aluno a) {
        return nome.compareToIgnoreCase(a.getNome());
    }

    @Override
    public String toString() {
        return "{Nome: " + nome +
                ", Matrícula: " + matricula +
                ", Nota: " + media + "}";
    }
}

class ComparatorPorMedia implements Comparator<Aluno>{
    // comparar por média
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getMedia(), a2.getMedia());
    }
}

class ComparatorPorMatricula implements Comparator<Aluno>{
    // comparar por matrícula
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Long.compare(a1.getMatricula(), a2.getMatricula());
    }
}