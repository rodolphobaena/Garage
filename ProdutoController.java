package poo.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import poo.projeto.projeto1.services.EstoqueService;
import poo.projeto.projeto1.services.ProdutoService;

@Controller
public class ProdutoController {
    
    private final ProdutoService produtoService;

    public ProdutoController(EstoqueService estoqueService, ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos/index") // Changed to lowercase "produtos"
    public String index() {
        return "produtos/index";
    }

    @GetMapping("/produtos/listar") // Changed to lowercase "produtos"
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("produtos/todos"); // Changed to lowercase "produtos"
        mv.addObject("listaProdutos", produtoService.findAll()); // Use "produtoService" consistently
        return mv;
    }
}
