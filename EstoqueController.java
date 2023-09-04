package poo.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import poo.projeto.projeto1.model.Estoque;
import poo.projeto.projeto1.model.Produto;
import poo.projeto.projeto1.services.EstoqueService;
import poo.projeto.projeto1.services.ProdutoService;

@Controller
public class EstoqueController {
    private final EstoqueService estoqueService; // Corrigir nome da variável
    private final ProdutoService produtoService; // Corrigir nome da variável

    public EstoqueController(EstoqueService estoqueService, ProdutoService produtoService) {
        this.estoqueService = estoqueService;
        this.produtoService = produtoService;
    }

    // ... (outros métodos do controlador)

    @PostMapping("/Estoque/incluir") // Corrigir o mapeamento
    public ModelAndView novoProduto(Estoque e) {
        ModelAndView mv = new ModelAndView();

        try {
            Produto produto = produtoService.findByNome(e.getNome_produto()); // Corrigir nome do método
            if (produto != null) {
                if (estoqueService.updateQuantidade(produto, -1)) {
                    estoqueService.insert(e);
                    mv.setViewName("redirect:/estoque/listar"); // Corrigir o nome da view
                } else {
                    mv.setViewName("estoque/incluir");
                    mv.addObject("umProduto", e);
                    mv.addObject("erro", "Produto indisponível no estoque");
                }
            } else {
                mv.setViewName("estoque/incluir");
                mv.addObject("umProduto", e);
                mv.addObject("erro", "Produto não encontrado");
            }
        } catch (Exception ex) {
            mv.setViewName("estoque/incluir");
            mv.addObject("umProduto", e);
            mv.addObject("erro", ex.getMessage().toString());
        }
        return mv;
    }
}
