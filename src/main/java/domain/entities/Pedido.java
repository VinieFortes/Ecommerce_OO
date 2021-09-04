package domain.entities;


import domain.valueObjects.PedidoStatus;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int codigo;
    private boolean voucherUtilizado;
    private double desconto;
    private double valorTotal;
    private Date dataCadastro;
    private PedidoStatus pedidoStatus;
    private Cliente cliente;
    private List<PedidoItem> _pedidoItems;
}
