package domain.entities;

import domain.valueObjects.TipoDescontoVoucher;

import java.util.Date;

public class Voucher {
    private String codigo;
    private Double percentual;
    private Double valorDesconto;
    private int quantidade;
    private TipoDescontoVoucher tipoDesconto;
    private Date dataCriacao;
    private Date dataUtilizacao;
    private Date dataValidade;
    private boolean ativo;
    private boolean utilizado;

    public TipoDescontoVoucher getTipoDesconto() {
        return tipoDesconto;
    }

    public Double getPercentual() {
        return percentual;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataUtilizacao() {
        return dataUtilizacao;
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
