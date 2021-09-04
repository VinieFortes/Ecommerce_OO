package domain.entities;

import java.util.UUID;

public class CarrinhoItem extends Entity {

    private Produto produto;
    private Carrinho carrinho;
    private int quantidade;

    public CarrinhoItem(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public CarrinhoItem(Produto produto) {
        this.produto = produto;
    }

    public Double CalcularValor()
    {
        return quantidade * produto.getValor();
    }

    public void AtribuirCarrinho(Carrinho carrinho){
        if(carrinho == null){
            throw new IllegalArgumentException("O carrinho não pode ser nulo");
        }
        this.carrinho = carrinho;
    }

    public void AdicionarUnidades(int unidades)
    {
        if(quantidade < 0){
            throw new IllegalArgumentException("A quantidade não pode ser menor que zero");
        }
        quantidade += unidades;
    }

    public void AtualizarUnidades(int unidades)
    {
        if(quantidade < 0){
            throw new IllegalArgumentException("A quantidade não pode ser menor que zero");
        }
        quantidade = unidades;
    }

    public UUID getProductId() {
        return produto.getId();
    }

    public String getNomeProduto() {
        return produto.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorProduto() {
        return produto.getValor();
    }
}
