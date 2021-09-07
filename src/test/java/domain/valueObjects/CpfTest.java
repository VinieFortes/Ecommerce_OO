package domain.valueObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void construtor_deveSoltarExcessaoCasoNumeroForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () ->{
           new Cpf(null);
        });

        assertEquals("O numero de cpf não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoNumeroTiverMaisQueOnzeDigitos(){
        var ex = assertThrows(IllegalArgumentException.class, () ->{
            new Cpf("123456789111");
        });

        assertEquals("O numero de cpf deve ter 11 digitos", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoNumeroTNaoTiverSoDigitos(){
        var ex = assertThrows(IllegalArgumentException.class, () ->{
            new Cpf("123456t8911");
        });

        assertEquals("O numero deve conter apenas números", ex.getMessage());
    }

    @Test
    void construtor_deveAtribuirNumero(){
        var cpf = new Cpf("12345678911");

        assertEquals("12345678911", cpf.getNumero());
    }


}