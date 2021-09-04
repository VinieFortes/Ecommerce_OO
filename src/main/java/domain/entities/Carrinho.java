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

    public void aplicarVoucher(Voucher voucher){
        if (voucher == null) {
            throw new IllegalArgumentException("O voucher precisa ser informado");
        }
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

    public boolean carrinhoItemExistente(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        for(var i : itens){
            if(i.getProductId() == item.getProductId());
                return true;
        }

        return false;
    }

    public CarrinhoItem obterPorProdutoId(UUID produtoId){
        if (produtoId == null) {
            throw new IllegalArgumentException("O ID precisa ser informado");
        }
        for(var i : itens){
            if(i.getProductId() == produtoId);
                return i;
        }
        return null;
    }

    public void AdicionarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        item.AtribuirCarrinho(this);
        if (carrinhoItemExistente(item)){
            var itemExistente = obterPorProdutoId(item.getProductId());
                itemExistente.AdicionarUnidades(item.getQuantidade());
                item = itemExistente;
                this.itens.remove(itemExistente);
            }
        this.itens.add(item);
        calcularValorCarrinho();
        }

    public void atualizarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        item.AtribuirCarrinho(this);
        var itemExistente = obterPorProdutoId(item.getProductId());

        this.itens.remove(itemExistente);
        this.itens.add(item);

        calcularValorCarrinho();
    }

    public void atualizarUnidades(CarrinhoItem item, int unidades){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        item.AtualizarUnidades(unidades);
        atualizarItem(item);
    }

    public void removerItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        this.itens.remove(obterPorProdutoId(item.getProductId()));
        calcularValorCarrinho();
    }
}
