import models.Cliente;
import models.Produto;
import models.Pedido;
import services.SistemaPagamentoExterno;

public class LojinhaOnlineSimulacao {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO LOJINHA ONLINE ---\n");

        Cliente cliente = new Cliente(1, "João da Silva");
        Produto p1 = new Produto(101, "Teclado Mecânico", 350.00);
        Produto p2 = new Produto(102, "Mouse Sem Fio", 150.00);

        Pedido meuPedido = new Pedido(1001, cliente);
        meuPedido.adicionarProduto(p1);
        meuPedido.adicionarProduto(p2);

        System.out.println("Carrinho fechado. Valor: R$" + meuPedido.getValorTotal());

        SistemaPagamentoExterno gateway = SistemaPagamentoExterno.getInstancia();
        boolean aprovado = gateway.processarPagamento(meuPedido);

        if (aprovado) {
            System.out.println("-> SUCESSO: Pagamento Aprovado!");
        } else {
            System.out.println("-> ERRO: Pagamento Recusado.");
        }
    }
}