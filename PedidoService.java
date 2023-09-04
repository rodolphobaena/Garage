package poo.projeto.projeto1.services;

import org.springframework.stereotype.Service;
import poo.projeto.projeto1.model.Pedido;
import poo.projeto.projeto1.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = buscarPedidoPorId(id);

        pedido.setNomeCliente((String) pedidoAtualizado.getCliente());
        pedido.setNumPedido((String) pedidoAtualizado.getDataPedido());
        pedido.setEntrega(pedidoAtualizado.getEntrega());
        pedido.setNome_produto((String) pedidoAtualizado.getProduto());
        // Atualize outros campos conforme necessário

        return pedidoRepository.save(pedido);
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void excluirPedido(Long id) {
        Pedido pedido = buscarPedidoPorId(id);
        pedidoRepository.delete(pedido);
    }
}
