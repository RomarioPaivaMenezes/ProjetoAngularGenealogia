package com.example.algamoney.api.repository.casamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Casamento;
import com.example.algamoney.api.repository.filter.CasamentoFilter;


public interface CasamentoRepositoryQuery {

	public Page<Casamento> filtrar(CasamentoFilter casamentoFilter, Pageable pageable);
	//public Page<Casamento> resumir(CasamentoFilter casamentoFilter, Pageable pageable);

}
