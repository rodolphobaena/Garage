package poo.projeto.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo.projeto.projeto1.model.Produto; // Importe corretamente a classe Produto
import poo.projeto.projeto1.model.ProdutoId;

public interface ProdutoRepository extends JpaRepository<Produto, ProdutoId> {
    // Você pode adicionar consultas personalizadas se necessário
}
