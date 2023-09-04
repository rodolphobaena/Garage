package poo.projeto.projeto1.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import poo.projeto.projeto1.model.Cliente;
import poo.projeto.projeto1.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Cliente cliente) throws Exception {
        try {
            repository.delete(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Este registro está em uso por outros processos.", e);
        }
    }

    public void update(Cliente cliente) throws Exception {
        if (exist(cliente)) {
            repository.save(cliente);
        } else {
            throw new Exception("Registro não encontrado");
        }
    }

    private boolean exist(Cliente cliente) {
        return repository.existsById(cliente.getRegistro_cliente());
    }

    public void insert(Cliente cliente) throws Exception {
        if (exist(cliente)) {
            throw new Exception("Este registro já está cadastrado");
        } else {
            repository.save(cliente);
        }
    }

    public Cliente findByRegistro(long registro) {
        return repository.findByRegistro(registro);
    }
}
