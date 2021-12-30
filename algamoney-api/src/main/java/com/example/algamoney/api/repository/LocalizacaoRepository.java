package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Localizacao;

public interface LocalizacaoRepository  extends JpaRepository<Localizacao, Long>{

}
