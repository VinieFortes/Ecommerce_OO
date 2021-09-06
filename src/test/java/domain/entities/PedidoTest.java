package domain.entities;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void construtor_deveSoltarExcessaoCasoNomeForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new Produto(null, "", 0.0d, 0);
        });

        assertEquals("O nome não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoDescricaoForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", null, 0.0d, 0);
        });

        assertEquals("A descrição não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoValorForMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", "", -1.0d, 0);
        });

        assertEquals("O valor não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoQuantidadeEstoqueForMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", "", 0.0d, -1);
        });

        assertEquals("A quantidade estoque não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void construtor_naoDeveSoltarExcessaoCasoOsParametrosSejamValidos(){
        var produto = new Produto("", "", 0.0d, 1);

        assertNotNull(produto);
    }

}