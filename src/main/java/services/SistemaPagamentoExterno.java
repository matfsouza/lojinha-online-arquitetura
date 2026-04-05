package services;

import models.Pedido;

public class SistemaPagamentoExterno {

    private static SistemaPagamentoExterno instancia;

    private SistemaPagamentoExterno() {
        System.out.println("[SISTEMA EXTERNO] Conexão com Gateway estabelecida.");
    }

    public static SistemaPagamentoExterno getInstancia() {
        if (instancia == null) {
            instancia = new SistemaPagamentoExterno();
        }
        return instancia;
    }

    public boolean processarPagamento(Pedido pedido) {
        System.out.println("[SISTEMA EXTERNO] Processando R$" + pedido.getValorTotal() +
                " para " + pedido.getCliente().getNome() + "...");
        return pedido.getValorTotal() > 0;
    }
}