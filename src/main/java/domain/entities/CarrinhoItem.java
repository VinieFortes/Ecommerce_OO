package domain.entities;

import java.util.UUID;

public class CarrinhoItem extends Entity {

    private Produto produto;
    private Carrinho carrinho;
    private int quantidade;

    public CarrinhoItem(int quantidade, Produto produto) {
        if(quantidade < 0){
            throw new IllegalArgumentException("A Quantidade não pode ser menor que zero");
        }
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo");
        }

        this.quantidade = quantidade;
        this.produto = produto;
    }


    public Double calcularValor()
    {
        return quantidade * produto.getValor();
    }

    public void atribuirCarrinho(Carrinho carrinho){
        if(carrinho == null){
            throw new IllegalArgumentException("O carrinho não pode ser nulo");
        }
        this.carrinho = carrinho;
    }

    public void adicionarUnidades(int unidades)
    {
        if(unidades  < 0){
            throw new IllegalArgumentException("A unidade não pode ser menor que zero");
        }
        this.quantidade += unidades;
    }

    public void atualizarUnidades(int unidades)
    {
        if(unidades < 0){
            throw new IllegalArgumentException("A unidade não pode ser menor que zero");
        }
        this.quantidade = unidades;
    }

    public String getProdutoId() {
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

    public String getCarrinhoId(){ return carrinho.getId(); }
}
