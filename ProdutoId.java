package poo.projeto.projeto1.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date; // Importação para as datas

@Getter
@Setter
@Embeddable
public class ProdutoId {
  
    private int ano;
    private int semestre;
    
    @ManyToOne
    @JoinColumn(name = "codPedido") // Alterado para "codPedido"
    private Pedido pedido; // Alterado para "Pedido"
    
    @ManyToOne
    @JoinColumn(name = "ra")
    private Cliente cliente;

    // Adicionando campos de data
    private Date dataFabricacao;
    private Date dataValidade;
    
    @ManyToOne
    @JoinColumn(name = "estoque_id") // Nome da coluna que relaciona com a tabela de Estoque
    private Estoque estoque; // Substitua "Estoque" pelo nome correto da classe de estoque
}
