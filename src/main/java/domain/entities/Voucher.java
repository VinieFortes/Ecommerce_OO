package domain.entities;

import domain.interfaces.IDesconto;

import java.util.Date;

public abstract class Voucher implements IDesconto {
    private String codigo;
    private int quantidade;
    private Date dataCriacao;
    private Date dataValidade;
    private boolean ativo;
    private boolean utilizado;


    public Voucher(String codigo, int quantidade, Date dataValidade) {
        if(codigo == null){
            throw new IllegalArgumentException("O codigo não pode ser nulo");
        }
        if(dataValidade == null){
            throw new IllegalArgumentException("A data de validade não pode ser nulo");
        }
        if(quantidade < 0){
            throw new IllegalArgumentException("A quantidade não pode ser menor que zero");
        }

        this.codigo = codigo;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.utilizado = false;
        this.ativo = true;
        this.dataCriacao = new Date();
    }

    public void desativar(){
        this.ativo = false;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public String getCodigo() {
        return codigo;
    }
}
