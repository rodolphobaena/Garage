package poo.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import poo.projeto.projeto1.model.Cliente;
import poo.projeto.projeto1.services.ClienteService; // Correção do nome do serviço

@Controller
public class ClienteController {
    private final ClienteService cliSr;

    public ClienteController(ClienteService cliSr) {
        this.cliSr = cliSr;
    }

    @GetMapping("clientes/index")
    public String index() {
        return "clientes/index";
    }

    @GetMapping("clientes/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("clientes/todos");
        mv.addObject("ListaDeClientes", cliSr.findAll());
        return mv;
    }

    @GetMapping("clientes/editar")
    public ModelAndView editar(@RequestParam("id") long registro) {
        ModelAndView mv = new ModelAndView("clientes/editar");
        Cliente cli = cliSr.findByRegistro(registro);
        if (cli == null) {
            mv = new ModelAndView("NaoEncontrado");
        } else {
            mv.addObject("umCliente", cli);
        }
        return mv;
    }

    @PostMapping("clientes/editar")
    public ModelAndView salvar(Cliente cli) {
        ModelAndView mv;
        try {
            cliSr.update(cli);
            mv = new ModelAndView("redirect:/clientes/listar");
        } catch (Exception e) {
            mv = new ModelAndView("clientes/editar");
            mv.addObject("umCliente", cli); // Correção do nome do objeto
            mv.addObject("erro", e.getMessage());
        }

        return mv;
    }

    // Restante do código similar...
}
