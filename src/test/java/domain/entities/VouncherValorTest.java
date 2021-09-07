package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VouncherValorTest {

    @Test
    void construtor_deveSoltaExcessaoCasoValorForMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
           new VouncherValor("any", 1, new Date(), -1.0d);
        });

        assertEquals("O valor de desconto tem que ser maior que zero", ex.getMessage());
    }

    @Test
    void construtor_deveSetarOValorDeDesconto(){
        var voucher = new VouncherValor("any", 1, new Date(), 10.0d);

        assertEquals(10.0d, voucher.getValorDesconto());
    }

    @Test
    void calcularTotalComDesconto_deveRetornarZeroQuandoDescontoForMaiorQueOValor(){
        var voucher = new VouncherValor("any", 1, new Date(), 10.0d);

        assertEquals(0.0d, voucher.calcularTotalComDesconto(9.0d));
    }

    @Test
    void calcularTotalComDesconto_deveRetornarOValorComDesconto(){
        var voucher = new VouncherValor("any", 1, new Date(), 10.0d);

        assertEquals(5.0d, voucher.calcularTotalComDesconto(15.0d));
    }
}