package domain.entities;

import java.util.Date;

public class VouncherValor extends Voucher {

    private Double valorDesconto;

    public VouncherValor(String codigo, int quantidade, Date dataValidade, Double valorDesconto) {
        super(codigo, quantidade, dataValidade);

        if(valorDesconto<0){
            throw new IllegalArgumentException("O valor de desconto tem que ser maior que zero");
        }

        this.valorDesconto = valorDesconto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public double calcularTotalComDesconto(double valorBase) {
        var valorComDesconto = valorBase - this.valorDesconto;
        return valorComDesconto > 0.0d ? valorComDesconto : 0.0d;
    }
}
