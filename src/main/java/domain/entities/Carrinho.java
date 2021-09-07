package domain.entities;

import java.util.List;

/*
 * Grupo
 *
 * Vinicius Fortes
 * Yuri Dias
 *
 * */

public class Carrinho extends Entity{

    private double valorTotal;
    private List<CarrinhoItem> itens;
    private double desconto;
    private Voucher voucher;
    private boolean voucherUtilizado;

    public Carrinho(List<CarrinhoItem> itens) {
        if(itens == null){
            throw new IllegalArgumentException("A lista de itens não pode ser nula");
        }
        this.itens = itens;
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
        return this.desconto;
    }



    public boolean itemExistente(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }

        for(var i : itens){
            if(i.getProdutoId().equals(item.getProdutoId()))
                return true;
        }

        return false;
    }

    public CarrinhoItem obterPorProdutoId(String produtoId){
        if (produtoId == null) {
            throw new IllegalArgumentException("O ID precisa ser informado");
        }
        for(var item : itens){
            if(item.getProdutoId().equals(produtoId)) {
                return item;
            }
        }
        return null;
    }

    public void adicionarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }

        item.atribuirCarrinho(this);

        if (itemExistente(item)){
            var itemJaExistente = obterPorProdutoId(item.getProdutoId());
            itemJaExistente.adicionarUnidades(item.getQuantidade());
            atualizarItem(itemJaExistente);
        }else{
            this.itens.add(item);
        }
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
            return;
        }

        item.atualizarUnidades(unidades);
        atualizarItem(item);
    }

    public void removerItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }
        this.itens.remove(item);
    }

    public List<CarrinhoItem> getListaProdutos() {
        return itens;
    }

    public String getId() {
        return id;
    }



    public Voucher getVoucher() {
        return voucher;
    }

    private void calcularValorTotalDesconto()
    {
        if (!voucherUtilizado) return;

        double valorComDesconto = voucher.calcularTotalComDesconto(this.valorTotal);

        this.desconto = this.valorTotal - valorComDesconto;

        this.valorTotal = valorComDesconto;
    }

    public void atualizarItem(CarrinhoItem item){
        if (item == null) {
            throw new IllegalArgumentException("O item precisa ser informado");
        }

        item.atribuirCarrinho(this);

        CarrinhoItem itemExistente = obterPorProdutoId(item.getProdutoId());

        if(this.itens.remove(itemExistente)){
            this.itens.add(item);
        }
    }

    private void calcularValorCarrinho()
    {
        for (var item: itens) {
            this.valorTotal += item.calcularValor();
        }
        calcularValorTotalDesconto();
    }


}
