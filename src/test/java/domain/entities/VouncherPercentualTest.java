package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VouncherPercentualTest {

    @Test
    void construtor_deveSoltarExcessaoCasoPercentualSejaMenorQueZero() {
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new VouncherPercentual("any", 1, new Date(), -0.5d);
        });

        assertEquals("O percentual não pode ser menor que 0", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoPercentualSejaMaiorQueUm() {
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new VouncherPercentual("any", 1, new Date(), 1.1d);
        });

        assertEquals("O percentual não pode ser maior que 1", ex.getMessage());
    }

    @Test
    void construtor_deveSetarOPercentualPassado() {
        var voucher = new VouncherPercentual("any", 1, new Date(), 0.8d);

        assertEquals(0.8d, voucher.getPercentual());
    }

    @Test
    void getPercentual_deveRetornarOPercentual(){
        var voucher = new VouncherPercentual("any", 1, new Date(), 0.7d);

        assertEquals(0.7d, voucher.getPercentual());
    }

    @Test
    void calcularTotalComDesconto_deveRetornarOValorComDesconto(){
        var voucher = new VouncherPercentual("any", 1, new Date(), 0.5d);

        assertEquals(50.0d, voucher.calcularTotalComDesconto(100.0d));
    }
}