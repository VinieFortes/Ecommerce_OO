package domain.entities;

import java.util.UUID;

public class CarrinhoItem extends Entity {

    private UUID productId;
    private Carrinho carrinho;
    private String nome;
    private int quantidade;
    private double valor;
    private String imagem;

    public Double CalcularValor()
    {
        return quantidade * valor;
    }

    public void AtribuirCarrinho(Carrinho carrinho){
        this.carrinho = carrinho;
    }

    public void AdicionarUnidades(int unidades)
    {
        quantidade += unidades;
    }

    public void AtualizarUnidades(int unidades)
    {
        quantidade = unidades;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    public String getImagem() {
        return imagem;
    }
}
