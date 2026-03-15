package com.arthur.treinando.padroes_projeto_spring.Service.Impl;

import com.arthur.treinando.padroes_projeto_spring.Model.Cliente;
import com.arthur.treinando.padroes_projeto_spring.Repository.ClienteRepository;
import com.arthur.treinando.padroes_projeto_spring.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.comments.CommentLine;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).get();
        return cliente;
    }

    @Override
    public void inserir(Cliente cliente) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome(cliente.getNome());
        cliente1.setEndereco(cliente.getEndereco());

        repository.save(cliente1);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
