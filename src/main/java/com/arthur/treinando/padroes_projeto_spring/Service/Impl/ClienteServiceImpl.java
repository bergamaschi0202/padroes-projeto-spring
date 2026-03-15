package com.arthur.treinando.padroes_projeto_spring.Service.Impl;

import com.arthur.treinando.padroes_projeto_spring.Model.Cliente;
import com.arthur.treinando.padroes_projeto_spring.Model.Endereco;
import com.arthur.treinando.padroes_projeto_spring.Repository.ClienteRepository;
import com.arthur.treinando.padroes_projeto_spring.Repository.EnderecoRepository;
import com.arthur.treinando.padroes_projeto_spring.Service.ClienteService;
import com.arthur.treinando.padroes_projeto_spring.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.comments.CommentLine;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = repository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }
}
