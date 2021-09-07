package domain.entities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoucherTest {

    @Test
    void construtor_deveSoltaExcessaoCasoCodigoDoVoucherForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new VouncherValor(null, 1, new Date(), 1.0d);
        });

        assertEquals("O codigo não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltaExcessaoCasoDataDeValidadeForNula(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new VouncherValor("any", 1, null, 1.0d);
        });

        assertEquals("A data de validade não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltaExcessaoCasoQuantidadeForMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new VouncherValor("any", -1, new Date(), 1.0d);
        });

        assertEquals("A quantidade não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void construtor_deveConstruirOObjetoComFlagAtivoTrue(){
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);

        assertTrue(voucher.isAtivo());
    }

    @Test
    void construtor_deveConstruirOObjetoComFlagUtilizadoFalse(){
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);

        assertFalse(voucher.isUtilizado());
    }

    @Test
    void desativar_deveSetarAFlagAtivoParaFalse(){
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);

        voucher.desativar();

        assertFalse(voucher.isAtivo());
    }

    @Test
    void desativar_deveSetarAFlagUtilizadoParaTrue(){
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);

        voucher.utilizar();

        assertTrue(voucher.isUtilizado());
    }

    @Test
    void getQuantidade_deveRetornarAQuantidade(){
        var voucher = new VouncherValor("any", 2, new Date(), 1.0d);

        assertEquals(2, voucher.getQuantidade());
    }

    @Test
    void getDataValidade_deveRetornarADataDeValidade() throws ParseException {
        var formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatoData.parse("07/09/2021");
        var voucher = new VouncherValor("any", 2, data, 1.0d);

        assertEquals(data, voucher.getDataValidade());
    }

    @Test
    void getDataValidade_deveRetornarADataDeCriacao() throws ParseException {
        var formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatoData.parse("07/09/2021");
        var voucher = new VouncherValor("any", 2, data, 1.0d);

        assertEquals(data.getDate(), voucher.getDataCriacao().getDate());
    }

    @Test
    void isAtivo_deveRetornarTrue(){
        var voucher = new VouncherValor("any", 2, new Date(), 1.0d);

        assertTrue(voucher.isAtivo());
    }

    @Test
    void isUtilizado_deveRetornarFalse(){
        var voucher = new VouncherValor("any", 2, new Date(), 1.0d);

        assertFalse(voucher.isUtilizado());
    }

    @Test
    void getCodigo_deveRetornarOCodigoDoCupom(){
        var voucher = new VouncherValor("any", 2, new Date(), 1.0d);

        assertEquals("any", voucher.getCodigo());
    }
}