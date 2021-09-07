package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoItemTest {
    private Produto produtoValido;
    private CarrinhoItem carrinhoItemValido;

    @BeforeEach
    void setUp() {
        this.produtoValido = new Produto("camisa", "Tamanho M", 2, 1);
        this.carrinhoItemValido = new CarrinhoItem(2, produtoValido);
    }

    @Test
    void construtor_deveRetornarExcessaoCasoQuantidadeSejaMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new CarrinhoItem(-1, produtoValido);
        });

        assertEquals("A Quantidade não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void construtor_deveRetornarExcessaoCasoProdutoSejaNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            new CarrinhoItem(1, null);
        });

        assertEquals("O produto não pode ser nulo", ex.getMessage());
    }

    @Test
    void construtor_deveConstruirOObjetoComAsInformacoesPassadas(){
        var carrinhoItem = new CarrinhoItem(1, produtoValido);

        assertEquals(1, carrinhoItem.getQuantidade());
        assertEquals(produtoValido.getId(), carrinhoItem.getProdutoId());
    }

    @Test
    void calcularValor_deveCalcularOValorDoItem(){
        var carrinhoItem = new CarrinhoItem(2, produtoValido);

        assertEquals(4, carrinhoItem.calcularValor());
    }

    @Test
    void atribuirCarrinho_deveRetornarUmaExcessaoCasoCarrinhoForNulo(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            this.carrinhoItemValido.atribuirCarrinho(null);
        });

        assertEquals("O carrinho não pode ser nulo", ex.getMessage());
    }

    @Test
    void atribuirCarrinho_deveAtribuirOCarrinho(){
        var carrinho = new Carrinho(new ArrayList<>());
        this.carrinhoItemValido.atribuirCarrinho(carrinho);

        assertEquals(carrinho.getId(), this.carrinhoItemValido.getCarrinhoId());
    }

    @Test
    void adicionarUnidades_deveRetornarExcessaoCasoAQuantidadeSejaMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            this.carrinhoItemValido.adicionarUnidades(-1);
        });

        assertEquals("A unidade não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void adicionarUnidades_deveAdicionarAQuantidadeInformada(){
        this.carrinhoItemValido.adicionarUnidades(1);

        assertEquals(3, this.carrinhoItemValido.getQuantidade());
    }

    @Test
    void getProdutoId(){
        var id = this.produtoValido.getId();
        var carrinhoItem = new CarrinhoItem(1, this.produtoValido);

        assertEquals(id, carrinhoItem.getProdutoId());
    }

    @Test
    void getNomeProduto(){
        var carrinhoItem = new CarrinhoItem(1, this.produtoValido);

        assertEquals(this.produtoValido.getNome(), carrinhoItem.getNomeProduto());
    }

    @Test
    void getQuantidade(){
        assertEquals(2, this.carrinhoItemValido.getQuantidade());
    }

    @Test
    void getValorProduto(){
        var carrinhoItem = new CarrinhoItem(1, this.produtoValido);

        assertEquals(this.produtoValido.getValor(), carrinhoItem.getValorProduto());
    }

    @Test
    void getCarrinhoId(){
        var carrinho = new Carrinho(new ArrayList<>());
        this.carrinhoItemValido.atribuirCarrinho(carrinho);

        assertEquals(carrinho.getId(), this.carrinhoItemValido.getCarrinhoId());
    }

    @Test
    void atualizarUnidades_deveSoltarExcessaoCasoUnidadesSejaMenorQueZero(){
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            this.carrinhoItemValido.atualizarUnidades(-1);
        });

        assertEquals("A unidade não pode ser menor que zero", ex.getMessage());
    }

    @Test
    void atualizarUnidades_deveAtualizarAsUnidadesDoProduto(){
        this.carrinhoItemValido.atualizarUnidades(3);

        assertEquals(3, this.carrinhoItemValido.getQuantidade());
    }

}