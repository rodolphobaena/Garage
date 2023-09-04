package poo.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poo.projeto.projeto1.model.Pedido;
import poo.projeto.projeto1.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "listar_pedidos"; // Nome da página HTML para listar pedidos
    }

    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        model.addAttribute("pedido", pedido);
        return "editar_pedido"; // Nome da página HTML para editar pedido
    }

    @PostMapping("/editar/{id}")
    public String salvarEdicao(@PathVariable Long id, @ModelAttribute Pedido pedido) {
        pedidoService.atualizarPedido(id, pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/novo")
    public String novoPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "novo_pedido"; // Nome da página HTML para criar novo pedido
    }

    @PostMapping("/novo")
    public String criarNovoPedido(@ModelAttribute Pedido pedido) {
        pedidoService.criarPedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
        return "redirect:/pedidos";
    }
}
