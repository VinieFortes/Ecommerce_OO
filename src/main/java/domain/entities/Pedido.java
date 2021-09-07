package domain.entities;
import domain.valueObjects.PedidoStatus;

import java.util.Date;
import java.util.List;

public class Pedido {
    private final double desconto;
    private final double valorTotal;
    private final PedidoStatus pedidoStatus;
    private final Cliente cliente;
    private final List<CarrinhoItem> pedidoItems;


    public Pedido(Cliente cliente, Carrinho carrinho) {
        if(cliente == null){
            throw new IllegalArgumentException("O cliente não pode ser nulo");
        }
        if(carrinho == null){
            throw new IllegalArgumentException("O carrinho não pode ser nulo");
        }

        this.pedidoStatus = PedidoStatus.Iniciado;
        this.cliente = cliente;
        this.pedidoItems = carrinho.getListaProdutos();
        this.valorTotal = carrinho.getValorTotal();
        this.desconto = carrinho.getDesconto();
    }

    public double getDesconto() {
        return this.desconto;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }


    public PedidoStatus getPedidoStatus() {
        return this.pedidoStatus;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}
