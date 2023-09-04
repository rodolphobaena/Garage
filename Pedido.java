package poo.projeto.projeto1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "tb_pedido")
public class Pedido extends Estoque {
    @Id
    @Column(length = 15, nullable = false, name = "num_pedido")
    private String numPedido;

    @Column(length = 25, nullable = false, name = "cliente_nome")
    private String nomeCliente;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "pedido")
    private List<ItemPedido> listaItens;

    public Object getDataPedido() {
        return null;
    }

    public Object getEntrega() {
        return null;
    }

    public Object getCliente() {
        return null;
    }

    public Object getProduto() {
        return null;
    }

    public void setEntrega(Object entrega) {
    }
}
