package domain.entities;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveRetornarNomeNulo(){
        try{
            Produto produto = new Produto(null, "Descricao do Produto", 1, 1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O nome não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarDescricaoNulo(){
        try{
            Produto produto = new Produto("camisa", null, 1, 1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A descrição não pode ser nulo", e.getMessage());
        }
    }
    @Test
    void deveRetornarValorMenorZero(){
        try{
            Produto produto = new Produto("camisa", "Tamanho M", -1, 1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O valor não pode ser menor que zero", e.getMessage());
        }
    }
    @Test
    void deveRetornarQuantidadeEstoqueMenorZero(){
        try{
            Produto produto = new Produto("camisa", "Tamanho M", 1, -1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("A quantidade estoque não pode ser menor que zero", e.getMessage());
        }
    }


    @Test
    void setValor_deveRetornarExcecaoCasoValorPassadoForMenorQueZero(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            produto.setValor(-1);
        });

        assertEquals("O valor não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void setValor_deveSetarOValorPassadoQuandoValido(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        produto.setValor(2.0d);

        assertEquals(2.0d, produto.getValor());
    }

    @Test
    void setQuantidadeEstoque_deveRetornarExcecaoCasoValorPassadoForMenorQueZero(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            produto.setQuantidadeEstoque(-1);
        });

        assertEquals("A quantidade estoque não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void setQuantidadeEstoque_deveSetarOValorPassadoQuandoValido(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        produto.setQuantidadeEstoque(2);

        assertEquals(2.0d, produto.getQuantidadeEstoque());
    }

    @Test
    void getValor_deveRetornarOValor(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertEquals(1, produto.getValor());
    }

    @Test
    void getNome_deveRetornarONome(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertEquals("camisa", produto.getNome());
    }

    @Test
    void getId_deveRetornarOId(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertNotNull(produto.getId());
    }

    @Test
    void getDescricao_deveRetornarADescricao(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertEquals("Tamanho M", produto.getDescricao());
    }

    @Test
    void isAtivo_deveRetornarTrue(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertTrue(produto.isAtivo());
    }

    void getQuantidadeEstoque_deveRetornarAQuantidadeEmEstoque(){
        var produto = new Produto("camisa", "Tamanho M", 1, 1);

        assertEquals(1, produto.getQuantidadeEstoque());
    }

}