package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Localizacao;
import com.example.algamoney.api.model.Permissao;
import com.example.algamoney.api.repository.LocalizacaoRepository;
import com.example.algamoney.api.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@GetMapping
	public List<Permissao> pesquisar() {
		return permissaoRepository.findAll();
	}
}
