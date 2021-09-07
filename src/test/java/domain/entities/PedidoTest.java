package domain.entities;

import domain.valueObjects.Cpf;
import domain.valueObjects.Email;
import domain.valueObjects.PedidoStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Cliente clienteValido;

    @BeforeEach
    void setUp() {
        this.clienteValido =
                new Cliente(
                "any",
                new Email("any@mail.com"),
                new Cpf("12312312390"),
                new Endereco("Rua A", "Cidade B", "MG", "Brasil", "1111111"));

    }

    @Test
    void construtor_deveSoltarExcessaoCasoClienteForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
           new Pedido(null, new Carrinho(new ArrayList<>()));
        });

        assertEquals("O cliente não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSoltarExcessaoCasoCarrinhoForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
           new Pedido(this.clienteValido, null);
        });

        assertEquals("O carrinho não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveSetarAFlagPedidoStatusComoPedidoIniciado(){
        var pedido = new Pedido(this.clienteValido, new Carrinho(new ArrayList<>()));

        assertEquals(PedidoStatus.Iniciado, pedido.getPedidoStatus());
    }

    @Test
    void construtor_deveSetarClientePassadoPorParametro(){
        var pedido = new Pedido(this.clienteValido, new Carrinho(new ArrayList<>()));

        assertEquals(this.clienteValido, pedido.getCliente());
    }

    @Test
    void construtor_deveSetarListaDeItensPassadaNoCarrinho(){
        var lista = new ArrayList<CarrinhoItem>();
        var pedido = new Pedido(this.clienteValido, new Carrinho(lista));

        assertEquals(lista, pedido.getPedidoItems());
    }

    @Test
    void construtor_deveSetarValorTotalRetornadoPeloCarrinho(){
        var lista = new ArrayList<CarrinhoItem>();
        var carrinho = new Carrinho(lista);
        var pedido = new Pedido(this.clienteValido, carrinho);

        assertEquals(carrinho.getValorTotal(), pedido.getValorTotal());
    }

    @Test
    void construtor_deveSetarValorDescontoRetornadoPeloCarrinho(){
        var lista = new ArrayList<CarrinhoItem>();
        var carrinho = new Carrinho(lista);
        carrinho.aplicarVoucher(new VouncherValor("any", 1, new Date(), 1.0d));
        var pedido = new Pedido(this.clienteValido, carrinho);

        assertEquals(carrinho.getDesconto(), pedido.getDesconto());
    }
}