package com.arthur.treinando.padroes_projeto_spring.Repository;

import com.arthur.treinando.padroes_projeto_spring.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
