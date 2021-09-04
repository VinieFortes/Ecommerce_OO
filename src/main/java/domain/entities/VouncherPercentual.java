package domain.entities;

import java.util.Date;

public class VouncherPercentual extends Voucher {
    private Double percentual;

    public VouncherPercentual(String codigo, int quantidade, Date dataValidade, Double percentual) {
        super(codigo, quantidade, dataValidade);

        if(percentual < 0){
            throw new IllegalArgumentException("O percentual não pode ser menor que 0");
        }
        if(percentual > 1){
            throw new IllegalArgumentException("O percentual não pode ser maior que 1");
        }

        this.percentual = percentual;
    }

    @Override
    public double calcularTotalComDesconto(double valorBase) {
        return valorBase - (valorBase*percentual);
    }
}
