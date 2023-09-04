package poo.projeto.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poo.projeto.projeto1.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Você pode adicionar consultas personalizadas se necessário
}
