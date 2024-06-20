package set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private long codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(long codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // um produto só é igual ao outro se o cod for o mesmo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    // comparar por nome
    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

    @Override
    public String toString() {
        return "{Código: " + codigo +
                ", Nome: '" + nome +
                ", Preco: " + preco +
                ", Quantidade: " + quantidade + "}";
    }
}

class ComparatorPorPreco implements Comparator<Produto>{
    // comparar por preco
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}

class ComparatorPorCodigo implements Comparator<Produto>{
    // comparar por codigo
    @Override
    public int compare(Produto p1, Produto p2) {
        return Long.compare(p1.getCodigo(), p2.getCodigo());
    }
}

class ComparatorPorQuantidade implements Comparator<Produto>{
    @Override
    public int compare(Produto p1, Produto p2) {
        return Integer.compare(p1.getQuantidade(), p2.getQuantidade());
    }
}