package poo.projeto.projeto1.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_produtos") // Corrigido para "tb_produtos"
@Getter
@Setter
@ToString
public class Produto { // Corrigido para "Produto"
    
    @EmbeddedId
    private ProdutoId id; // Corrigido para "ProdutoId"
    private String nome; // Adicionei um campo de exemplo
    private double preco; // Adicionei um campo de exemplo
    
    // Construtores, métodos e outros campos podem ser adicionados aqui
    
}
