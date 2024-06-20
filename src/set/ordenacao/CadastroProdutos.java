package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public void exibirProdutos(){
        if (!produtoSet.isEmpty()){
            System.out.println(produtoSet);
        } else {
            System.out.println("O conjunto SET de produtos está vazio!");
        }
    }

    public int totalProdutos(){
        return produtoSet.size();
    }

    public Set<Produto> exibirProdutosPorNome() {
    /* através da interface Comparable o método compareTo() definimos que
     * a ordem natural é por nome, por isso o TreeSet<>(produtoSet)
     * consegue deixar organizado por nome
     */
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()){
            return produtosPorNome;
        } else {
            throw new RuntimeException("O conjunto SET de produtos está vazio!");
        }

    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if (!produtoSet.isEmpty()) {
            produtosPorPreco.addAll(produtoSet);
            return produtosPorPreco;
        } else {
            throw new RuntimeException("O conjunto SET de produtos está vazio!");
        }
    }

    public Set<Produto> exibirPorCodigo(){
        Set<Produto> produtosPorCodigo = new TreeSet<>(new ComparatorPorCodigo());
        if (!produtoSet.isEmpty()) {
            produtosPorCodigo.addAll(produtoSet);
            return produtosPorCodigo;
        } else {
            throw new RuntimeException("O conjunto SET de produtos está vazio!");
        }
    }

    public Set<Produto> exibirPorQuantidade(){
        Set<Produto> produtosPorQuantidade = new TreeSet<>(new ComparatorPorQuantidade());
        if (!produtoSet.isEmpty()) {
            produtosPorQuantidade.addAll(produtoSet);
            return produtosPorQuantidade;
        } else {
            throw new RuntimeException("O conjunto SET de produtos está vazio!");
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.exibirProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto 0", 15d, 5);
        cadastroProdutos.adicionarProduto(2L, "Produto 7", 20d, 10);
        cadastroProdutos.adicionarProduto(1L, "Produto 2", 10d, 2);
        cadastroProdutos.adicionarProduto(3L, "Produto 4", 2d, 2);

        // obs: produtos que tem o mesmo código, não podem estar contido dentro do mesmo SET
        // 'Produto 2' foi desconsiderado por ter o mesmo cod
        System.out.println("Total de produtos: " + cadastroProdutos.totalProdutos());

        cadastroProdutos.exibirProdutos();

        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
        System.out.println(cadastroProdutos.exibirPorCodigo());
        System.out.println(cadastroProdutos.exibirPorQuantidade());
    }
}
