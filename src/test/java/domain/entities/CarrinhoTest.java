package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    @Test
    void deveRetornarVoucherNulo() {
        try{
            Produto produto = new Produto("Camisa","Tamanho M",20,500);
            CarrinhoItem carrinhoItem = new CarrinhoItem(2, produto);
            List<CarrinhoItem> carrinhoItems = List.of(carrinhoItem);
            Carrinho carrinho = new Carrinho(carrinhoItems, null);
            carrinho.aplicarVoucher(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O voucher precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNulo() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.itemExistente(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarIDNulo() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.obterPorProdutoId(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O ID precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoAdicionar() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.adicionarItem(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoAtualizar() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.atualizarItem(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoAtualizarUnidades() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.atualizarUnidades(null,1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarQuantidadeMenorZeroAoAtualizarUnidades() {
        try{
            Produto produto = new Produto("Camisa","Tamanho M",20,500);
            CarrinhoItem carrinhoItem = new CarrinhoItem(2, produto);
            Carrinho carrinho = new Carrinho();
            carrinho.atualizarUnidades(carrinhoItem,-1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A quantidade não pode ser menor que zero", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoRemover() {
        try{
            Carrinho carrinho = new Carrinho();
            carrinho.removerItem(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
}