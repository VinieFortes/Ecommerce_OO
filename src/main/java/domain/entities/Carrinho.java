package domain.entities;

import domain.valueObjects.TipoDescontoVoucher;

import java.util.List;
import java.util.UUID;

public class Carrinho {

    private final int MAX_QUANTIDADE_ITEM = 5;

    private double valorTotal;
    private List<CarrinhoItem> itens;
    private boolean voucherUtilizado;
    private double desconto;
    private Voucher voucher;

    public Carrinho(double valorTotal, List<CarrinhoItem> itens, boolean voucherUtilizado, double desconto, Voucher voucher) {
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.voucherUtilizado = voucherUtilizado;
        this.desconto = desconto;
        this.voucher = voucher;
    }

    public void aplicarVoucher(Voucher voucher)
    {
        this.voucher = voucher;
        this.voucherUtilizado = true;
        calcularValorCarrinho();
    }

    public void calcularValorCarrinho()
    {
        for (var item: itens) {
            this.valorTotal += item.CalcularValor();
        }
        calcularValorTotalDesconto();
    }

    private void calcularValorTotalDesconto()
    {
        if (!voucherUtilizado) return;

        Double desconto = 0.0d;
        var valor = this.valorTotal;

        if (this.voucher.getTipoDesconto() == TipoDescontoVoucher.Porcentagem)
        {
            desconto = (valor * this.voucher.getPercentual()) / 100;
            valor -= desconto;
        }
        else
        {
            desconto = voucher.getValorDesconto();
            valor -= desconto;
        }

        this.valorTotal = valor < 0 ? 0 : valor;
        this.desconto = desconto;
    }

    public boolean carrinhoItemExistente(CarrinhoItem item)
    {
        for(var i : itens){
            if(i.getProductId() == item.getProductId());
                return true;
        }

        return false;
    }

    public CarrinhoItem obterPorProdutoId(UUID produtoId)
    {
        for(var i : itens){
            if(i.getProductId() == produtoId);
                return i;
        }
        return null;
    }

    public void AdicionarItem(CarrinhoItem item)
    {
        item.AtribuirCarrinho(this);

        if (carrinhoItemExistente(item))
        {
            var itemExistente = obterPorProdutoId(item.getProductId());
            itemExistente.AdicionarUnidades(item.getQuantidade());

            item = itemExistente;
            this.itens.remove(itemExistente);
        }

        this.itens.add(item);
        calcularValorCarrinho();
    }

    public void atualizarItem(CarrinhoItem item)
    {
        item.AtribuirCarrinho(this);

        var itemExistente = obterPorProdutoId(item.getProductId());

        this.itens.remove(itemExistente);
        this.itens.add(item);

        calcularValorCarrinho();
    }

    public void atualizarUnidades(CarrinhoItem item, int unidades)
    {
        item.AtualizarUnidades(unidades);
        atualizarItem(item);
    }

    public void removerItem(CarrinhoItem item)
    {
        this.itens.remove(obterPorProdutoId(item.getProductId()));
        calcularValorCarrinho();
    }
}
