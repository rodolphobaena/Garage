package poo.projeto.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo.projeto.projeto1.model.Estoque;
import poo.projeto.projeto1.model.Pedido;

public interface EstoqueRepository extends JpaRepository<Pedido, Long> {

    Estoque saveAll(Estoque estoque);
    // Você pode adicionar consultas personalizadas se necessário

    Estoque findByNomeProduto(String produto);

    boolean existsByNomeProduto(String nome_produto);

    void delete(Estoque estoque);
}
