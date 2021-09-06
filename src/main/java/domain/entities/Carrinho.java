package domain.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrinho extends Entity{

    private double valorTotal;
    private List<CarrinhoItem> itens;
    private double desconto;
    private Voucher voucher;
    private boolean voucherUtilizado;

    public Carrinho(List<CarrinhoItem> itens, Voucher voucher) {
        this.itens = itens;
        this.voucher = voucher;
    }

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void aplicarVoucher(Voucher voucher){
        if (voucher == null) {
            throw new IllegalArgumentException("O voucher precisa ser informado");
        }

        this.voucher = voucher;
        this.voucherUtilizado = true;
    }

    public double getValorTotal() {
        calcularValorCarrinho();
        return valorTotal;
    }

    public double getDesconto() {
        calcularValorCarrinho();
        return desconto;
    }

    private void calcularValorCarrinho()
    {
        for (var item: itens) {
            this.valorTotal += item.CalcularValor();
        }
        calcularValorTotalDesconto();
    }

    private void calcularValorTotalDesconto()
    {
        if (!voucherUtilizado) return;

        double valorComDesconto = voucher.calcularTotalComDesconto(this.valorTotal);

        this.desconto = this.valorTotal - valorComDesconto;

        this.valorTotal = valorComDesconto;
    }

    public boolean itemExistente(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        for(var i : itens){
            if(i.getProductId() == item.getProductId())
                return true;
        }

        return false;
    }

    public CarrinhoItem obterPorProdutoId(UUID produtoId){
        if (produtoId == null) {
            throw new IllegalArgumentException("O ID precisa ser informado");
        }
        for(var item : itens){
            if(item.getProductId() == produtoId) {
                return item;
            }
        }
        return null;
    }

    public void adicionarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }

        item.AtribuirCarrinho(this);

        if (itemExistente(item)){
            var itemJaExistente = obterPorProdutoId(item.getProductId());
            itemJaExistente.AdicionarUnidades(item.getQuantidade());
            atualizarItem(itemJaExistente);
        }else{
            this.itens.add(item);
        }
    }

    public void atualizarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }

        item.AtribuirCarrinho(this);

        CarrinhoItem itemExistente = obterPorProdutoId(item.getProductId());

        this.itens.remove(itemExistente);
        this.itens.add(item);
    }

    public void atualizarUnidades(CarrinhoItem item, int unidades){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        if(unidades < 0){
            throw new IllegalArgumentException("A quantidade não pode ser menor que zero");
        }
        if(unidades == 0){
            removerItem(item);
        }

        item.AtualizarUnidades(unidades);
        atualizarItem(item);
    }

    public void removerItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        this.itens.remove(obterPorProdutoId(item.getProductId()));
    }

    public List<CarrinhoItem> getListaProdutos() {
        return itens;
    }
}
