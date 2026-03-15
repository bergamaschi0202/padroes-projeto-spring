package com.arthur.treinando.padroes_projeto_spring.Service;

import com.arthur.treinando.padroes_projeto_spring.Model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
