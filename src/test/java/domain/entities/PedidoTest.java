package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveRetornarClienteNulo(){
        try{
            Carrinho carrinho = new Carrinho();
            Pedido pedido = new Pedido(null, carrinho);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O cliente não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarCarrinhoNulo(){
        try{
            Cliente cliente = new Cliente();
            Pedido pedido = new Pedido(cliente, null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O carrinho não pode ser nulo", e.getMessage());
        }
    }

}