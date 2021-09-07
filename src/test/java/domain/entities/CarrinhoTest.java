package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    @Test
    void deveRetornarVoucherNulo() {
        try{
            Produto produto = new Produto("Camisa","Tamanho M",20,500);
            CarrinhoItem carrinhoItem = new CarrinhoItem(2, produto);
            List<CarrinhoItem> carrinhoItems = List.of(carrinhoItem);
            Carrinho carrinho = new Carrinho(carrinhoItems);
            carrinho.aplicarVoucher(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O voucher precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNulo() {
        try{
            Carrinho carrinho = new Carrinho(new ArrayList<>());
            carrinho.itemExistente(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarIDNulo() {
        try{
            Carrinho carrinho = new Carrinho(new ArrayList<>());
            carrinho.obterPorProdutoId(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O ID precisa ser informado", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoAdicionar() {
        try{
            Carrinho carrinho = new Carrinho(new ArrayList<>());
            carrinho.adicionarItem(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }

    @Test
    void deveRetornarItemNuloAoAtualizarUnidades() {
        try{
            Carrinho carrinho = new Carrinho(new ArrayList<>());
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
            Carrinho carrinho = new Carrinho(new ArrayList<>());
            carrinho.atualizarUnidades(carrinhoItem,-1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A quantidade não pode ser menor que zero", e.getMessage());
        }
    }
    @Test
    void deveRetornarItemNuloAoRemover() {
        try{
            Carrinho carrinho = new Carrinho(new ArrayList<>());
            carrinho.removerItem(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O item precisa ser informado", e.getMessage());
        }
    }

    @Test
    void construtor_deveSoltarExcessaoCasoListaDeItensSejaNull(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new Carrinho(null);
        });

        assertEquals("A lista de itens não pode ser nula", ex.getMessage());
    }

    @Test
    void constructor_deveConstruirObjetoSemExcessao(){
        assertNotNull(new Carrinho(new ArrayList<>()));
    }

    @Test
    void aplicarVoucher_deveAplicarOVouncher(){
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);
        var carrinho = new Carrinho(new ArrayList<>());
        carrinho.aplicarVoucher(voucher);

        assertEquals(voucher, carrinho.getVoucher());
    }

    @Test
    void getValorTotal_deveRetornarOvalorTotalDoCarrinho(){
        var listaItens = new ArrayList<CarrinhoItem>();
        listaItens.add(new CarrinhoItem(6, new Produto("camisa", "Tamanho M", 2, 1)));
        var carrinho = new Carrinho(listaItens);

        assertEquals(12, carrinho.getValorTotal());
    }

    @Test
    void getValorTotal_deveRetornarOvalorTotalDoCarrinhoComDescontoDoVoucher(){
        var listaItens = new ArrayList<CarrinhoItem>();
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);
        listaItens.add(new CarrinhoItem(6, new Produto("camisa", "Tamanho M", 2, 1)));
        var carrinho = new Carrinho(listaItens);
        carrinho.aplicarVoucher(voucher);

        assertEquals(11, carrinho.getValorTotal());
    }

    @Test
    void getDesconto_deveRetornarOValorDoCarrinho(){
        var listaItens = new ArrayList<CarrinhoItem>();
        var voucher = new VouncherValor("any", 1, new Date(), 1.0d);
        listaItens.add(new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1)));
        var carrinho = new Carrinho(listaItens);
        carrinho.aplicarVoucher(voucher);

        assertEquals(1, carrinho.getDesconto());
    }

    @Test
    void itemExistente_deveRetornarTrue(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var listaItens = new ArrayList<CarrinhoItem>();
        listaItens.add(item);
        var carrinho = new Carrinho(listaItens);


        assertTrue(carrinho.itemExistente(item));
    }

    @Test
    void itemExistente_deveRetornarFalse(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var listaItens = new ArrayList<CarrinhoItem>();
        var carrinho = new Carrinho(listaItens);

        assertFalse(carrinho.itemExistente(item));
    }

    @Test
    void adicionarItem_deveSoltarExcessaoCasoItemForNulo(){
        var carrinho = new Carrinho(new ArrayList<CarrinhoItem>());
        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.adicionarItem(null);
        });
    }

    @Test
    void adicionarItem_deveAtribuirCarrinhoEmItem(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var carrinho = new Carrinho(new ArrayList<CarrinhoItem>());
        carrinho.adicionarItem(item);

        assertEquals(carrinho.getId(), item.getCarrinhoId());
    }

    @Test
    void adicionarItem_deveAtualizarAQuantidadeCasoItemJaExista(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        lista.add(item);
        var carrinho = new Carrinho(lista);
        carrinho.adicionarItem(item);

        assertEquals(2, lista.get(0).getQuantidade());
    }

    @Test
    void adicionarItem_naoDeveAdicionarUmItemNaListaSeItemJaExistir(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        lista.add(item);
        var carrinho = new Carrinho(lista);
        carrinho.adicionarItem(item);

        assertEquals(1, lista.size());
    }

    @Test
    void adicionarItem_deveAdicionarItemAListaDeItens(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        var carrinho = new Carrinho(lista);
        carrinho.adicionarItem(item);

        assertEquals(1, lista.size());
    }

    @Test
    void adicionarItem_deveRemoverItemSeUnidadeForZero(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        lista.add(item);
        var carrinho = new Carrinho(lista);
        carrinho.atualizarUnidades(item, 0);

        assertEquals(0, lista.size());
    }

    @Test
    void adicionarItem_deveAtualizarAQuantidadeDoItem(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        lista.add(item);
        var carrinho = new Carrinho(lista);
        carrinho.atualizarUnidades(item, 2);

        assertEquals(2, lista.get(0).getQuantidade());
    }

    @Test
    void removerItem_deveRemoverItem(){
        var item = new CarrinhoItem(1, new Produto("camisa", "Tamanho M", 2, 1));
        var lista = new ArrayList<CarrinhoItem>();
        lista.add(item);
        var carrinho = new Carrinho(lista);
        carrinho.removerItem(item);

        assertEquals(0, lista.size());
    }

    @Test
    void getListaProdutos_deveRetornarListaDeProdutos(){
        var lista = new ArrayList<CarrinhoItem>();
        var carrinho = new Carrinho(lista);

        assertEquals(lista, carrinho.getListaProdutos());
    }
}