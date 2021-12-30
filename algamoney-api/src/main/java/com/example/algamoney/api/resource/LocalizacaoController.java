package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Localizacao;
import com.example.algamoney.api.repository.LocalizacaoRepository;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@GetMapping
	public List<Localizacao> pesquisar() {
		return localizacaoRepository.findAll();
	}
}
