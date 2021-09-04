package domain.entities;
import domain.valueObjects.PedidoStatus;

import java.util.Date;
import java.util.List;

public class Pedido {
    private double desconto;
    private double valorTotal;
    private Date dataPedido;
    private PedidoStatus pedidoStatus;
    private Cliente cliente;
    private List<CarrinhoItem> pedidoItems;


    public Pedido(Cliente cliente,
                  Carrinho carrinho) {
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
        this.dataPedido = new Date();
    }

    public double getDesconto() {
        return desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
