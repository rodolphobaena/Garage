package poo.projeto.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo.projeto.projeto1.model.Cliente;


public interface  ClienteRepository 
extends JpaRepository<Cliente,Long>{

    Cliente findByRegistro(long registro);
    
}
