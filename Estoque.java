package poo.projeto.projeto1.model;

import java.io.Serializable;

import jakarta.persistence.Column; // Correção de importação
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class Estoque implements Serializable {
    @Column(length = 50, nullable = false)
    private String nome_produto;
    
    @Column(length = 30)
    private String data_fabrica;
    
    @Column(length = 10)
    private String quantidade;

    // Construtores, métodos e outros campos podem ser adicionados aqui
}
