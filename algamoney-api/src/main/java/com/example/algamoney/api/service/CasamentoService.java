package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Casamento;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.CasamentoRepository;

@Service
public class CasamentoService {

	
	@Autowired 
	private CasamentoRepository casamentoRepository;

	public Casamento salvar(Casamento casamento) {
		return casamentoRepository.save(casamento);
	}

	public Casamento atualizar(Long codigo, Casamento lancamento) {
		Casamento casamentoSalvo = buscarCasamentoExistente(codigo);
		BeanUtils.copyProperties(lancamento, casamentoSalvo, "codigo");

		return casamentoRepository.save(casamentoSalvo);
	}



	private Casamento buscarCasamentoExistente(Long codigo) {
/* 		Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(codigo);
		if (lancamentoSalvo.isEmpty()) {
			throw new IllegalArgumentException();
		} */
		return casamentoRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException());
	}	
	
}
