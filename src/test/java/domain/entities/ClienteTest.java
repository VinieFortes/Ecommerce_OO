package domain.entities;

import domain.valueObjects.Cpf;
import domain.valueObjects.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;
    private Cpf cpf;
    private Email email;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        this.email = new Email("marco@gmail.com");
        this.cpf = new Cpf("10120230344");
        this.endereco= new Endereco("Rua José Lourenço Kelmer","Juiz de Fora", "MG", "Brasil", "36036-900");
        this.cliente = new Cliente("Marco", this.email, this.cpf, this.endereco);
    }

    @Test
    void deveRetornarClinteInativo() {
        this.cliente.setActive(false);
        assertFalse(cliente.isActive());
    }

    @Test
    void deveRetornarClienteAtivo() {
        this.cliente.setActive(true);
        assertTrue(cliente.isActive());
    }
    @Test
    void deveRetornarNomeCliente() {
        assertEquals("Marco", cliente.getNome());
    }
    @Test
    void deveRetornarEmailCliente() {
        assertEquals(this.email, cliente.getEmail());
    }
    @Test
    void deveRetornarCPFCliente() {
        assertEquals(this.cpf, cliente.getCpf());
    }
    @Test
    void deveRetornarEnderecoCliente() {
        assertEquals(this.endereco, cliente.getEndereco());
    }

}