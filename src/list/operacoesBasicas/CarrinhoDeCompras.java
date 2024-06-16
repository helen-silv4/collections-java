package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> removerItem = new ArrayList<>();
        if(!itemList.isEmpty()){
            for (Item i : itemList){
                if(i.getNome().equalsIgnoreCase(nome)){
                    removerItem.add(i);
                }
            }
            itemList.removeAll(removerItem);
        }
        else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0.0;
        if(!itemList.isEmpty()){
            for (Item i : itemList){
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        }
        else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(itemList);
        }
        else{
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itemList=" + itemList ;
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Livro Código Limpo", 80.0, 2);
        carrinhoDeCompras.adicionarItem("Livro Código Limpo", 80.0, 1);
        carrinhoDeCompras.adicionarItem("Livro Algoritmos", 60.0, 1);
        carrinhoDeCompras.adicionarItem("Marca Páginas", 5.0, 2);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Livro Código Limpo");

        carrinhoDeCompras.exibirItens();

        System.out.println("Valor total da compra: R$" + carrinhoDeCompras.calcularValorTotal());

    }
}