package poo.projeto.projeto1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import poo.projeto.projeto1.model.Produto; // Corrigido para Produto
import poo.projeto.projeto1.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repositorioProduto; // Corrigido para repositorioProduto

    public ProdutoService(ProdutoRepository repositorioProduto) {
        this.repositorioProduto = repositorioProduto;
    }

    public List<Produto> findAll() { // Corrigido para Produto
        return repositorioProduto.findAll();
    }

    public Produto findByNome(String nome_produto) {
        return null;
    }
}
