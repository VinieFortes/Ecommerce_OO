package domain.entities;

import java.util.Date;

public class VouncherValor extends Voucher {

    private Double valorDesconto;

    public VouncherValor(String codigo, int quantidade, Date dataValidade, Double valorDesconto) {
        super(codigo, quantidade, dataValidade);


        this.valorDesconto = valorDesconto;
    }

    @Override
    public double calcularTotalComDesconto(double valorBase) {
        var valorComDesconto = valorBase - this.valorDesconto;
        return valorComDesconto > 0 ? valorComDesconto : 0;
    }
}
