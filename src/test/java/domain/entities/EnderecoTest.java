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
    void deveRetornarLogadouroNulo() {
        try{
            Endereco endereco = new Endereco(null,"Juiz de Fora", "MG", "Brasil", "36036-900");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O logadouro não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarCidadeNulo() {
        try{
            Endereco endereco = new Endereco("Rua José Lourenço Kelmer",null, "MG", "Brasil", "36036-900");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A cidade não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarUFNulo() {
        try{
            Endereco endereco = new Endereco("Rua José Lourenço Kelmer","Juiz de Fora", null, "Brasil", "36036-900");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A UF não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarPaisNulo() {
        try{
            Endereco endereco = new Endereco("Rua José Lourenço Kelmer","Juiz de Fora", "MG", null, "36036-900");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O pais não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarCEPNulo() {
        try{
            Endereco endereco = new Endereco("Rua José Lourenço Kelmer","Juiz de Fora", "MG", "Brasil", null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O cep não pode ser nulo", e.getMessage());
        }
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