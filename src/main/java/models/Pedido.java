package models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> itens = new ArrayList<>();
    private double valorTotal = 0.0;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto p) {
        itens.add(p);
        valorTotal += p.getPreco();
    }

    public double getValorTotal() { return valorTotal; }
    public Cliente getCliente() { return cliente; }
}