package domain.entities;

import org.junit.jupiter.api.Test;

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

}