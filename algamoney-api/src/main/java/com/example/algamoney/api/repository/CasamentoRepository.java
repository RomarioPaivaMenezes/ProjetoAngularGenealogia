package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.algamoney.api.model.Casamento;
import com.example.algamoney.api.repository.casamento.CasamentoRepositoryQuery;

@Repository
public interface CasamentoRepository extends JpaRepository<Casamento, Long>, CasamentoRepositoryQuery{

}
