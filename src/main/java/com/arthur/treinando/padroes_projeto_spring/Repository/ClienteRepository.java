package com.arthur.treinando.padroes_projeto_spring.Repository;

import com.arthur.treinando.padroes_projeto_spring.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
