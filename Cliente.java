package poo.projeto.projeto1.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_reg", nullable = false)
    private long registro_cliente;

    @Column(name = "cli_pedido", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date datapedido;

    @Column(name = "cli_entrega", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date entrega;

    @Column(name = "cli_produto", nullable = false, length = 25)
    private String cli_produto;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "cliente")
    private List<Produto> listaProdutos;
}
