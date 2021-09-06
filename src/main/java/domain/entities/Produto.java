package domain.entities;

import java.util.Date;
import java.util.UUID;

public class Produto extends Entity {
    private String nome;
    private String descricao;
    private boolean ativo;
    private double valor;
    private Date dataCriacao;
    private int quantidadeEstoque;

    public Produto(String nome,
                   String descricao,
                   double valor,
                   int quantidadeEstoque) {
        if(nome == null){
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        if(descricao == null){
            throw new IllegalArgumentException("A descrição não pode ser nulo");
        }
        if(valor < 0){
            throw new IllegalArgumentException("O valor não pode ser menor que zero");
        }
        if(quantidadeEstoque < 0){
            throw new IllegalArgumentException("A quantidade estoque não pode ser menor que zero");
        }


        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.ativo = true;
        this.dataCriacao = new Date();
    }

    public Produto setValor(double valor) {
        if(valor < 0){
            throw new IllegalArgumentException("O valor não pode ser menor que zero");
        }

        this.valor = valor;
        return this;
    }

    public Produto setQuantidadeEstoque(int quantidadeEstoque) {
        if(quantidadeEstoque < 0){
            throw new IllegalArgumentException("A quantidade estoque não pode ser menor que zero");
        }

        this.quantidadeEstoque = quantidadeEstoque;
        return this;
    }

    public double getValor() {
        return this.valor;
    }

    public String getNome() {
        return this.nome;
    }

    public UUID getId() {
        return this.getId();
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
