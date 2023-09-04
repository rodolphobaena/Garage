package poo.projeto.projeto1.services;

import org.springframework.stereotype.Service;

import poo.projeto.projeto1.model.Estoque;
import poo.projeto.projeto1.model.Produto;
import poo.projeto.projeto1.repository.EstoqueRepository;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque findByProduto(String produto) {
        return estoqueRepository.findByNomeProduto(produto);
    }

    public Estoque save(Estoque estoque) {
        return estoqueRepository.saveAll(estoque);
    }
public void delete(Estoque estoque) {
    estoqueRepository.delete(estoque);
}

    
    public void update(Estoque estoque) throws Exception {
        if (exist(estoque)) {
            estoqueRepository.saveAll(estoque);
        } else {
            throw new Exception("Registro não encontrado");
        }
    }

    private boolean exist(Estoque estoque) {
        return estoqueRepository.existsByNomeProduto(estoque.getNome_produto());
    }

    public void insert(Estoque estoque) throws Exception {
        if (exist(estoque)) {
            throw new Exception("Este produto já está cadastrado");
        } else {
            estoqueRepository.saveAll(estoque);
        }
    }

    public boolean updateQuantidade(Estoque estoque, int quantidade) {
        estoque.setQuantidade(String.valueOf(quantidade));
        estoqueRepository.saveAll(estoque);
        return true;
    }

    public boolean updateQuantidade(Produto produto, int quantidade) {
        return false;
    }
}
