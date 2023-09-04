package poo.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import poo.projeto.projeto1.services.EstoqueService;

@Controller
public class InicioController {
    
    public InicioController(EstoqueService serv){
    }
    @GetMapping("/")
    public String index(){
       
        return "index";
    }

    // está lógiva foi movida para AlunosController
    
    // @GetMapping("pag2")
    // public ModelAndView  p2(){
    //     ModelAndView mv = new ModelAndView("pagina2");
    //     Aluno a = new Aluno();
    //     a.setCpf("1234");
    //     a.setCurso("um curso");
    //     a.setNome("aluno1");
    //     a.setRa("12345678");
    //     a.setRg("5678");
    //     mv.addObject("umAluno", a);
    //     return mv;

    // }

    // @PostMapping("pag2salvar")
    // public ModelAndView novoAluno(Aluno a){
    //     ModelAndView mv = new ModelAndView("index");
    //     asr.save(a);
    //     return mv;
    // }
}
