package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    private Endereco endereco;

    @BeforeEach
    void setUp() {
        this.endereco = new Endereco("Rua José Lourenço Kelmer","Juiz de Fora", "MG", "Brasil", "36036-900");
    }

    @Test
    void deveRetornarLogadouro() {
        assertEquals("Rua José Lourenço Kelmer", endereco.getLogadouro());
    }
    @Test
    void deveRetornarCidade() {
        assertEquals("Juiz de Fora", endereco.getCidade());
    }
    @Test
    void deveRetornarUF() {
        assertEquals("MG", endereco.getUF());
    }
    @Test
    void deveRetornarPais() {
        assertEquals("Brasil", endereco.getPais());
    }
    @Test
    void deveRetornarCEP() {
        assertEquals("36036-900", endereco.getCep());
    }
}