package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.CasamentoRepository;
import com.example.algamoney.api.repository.UsuarioRepository;
import com.example.algamoney.api.security.util.GeradorSenha;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class UsuarioService {

	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private GeradorSenha geradorSenha;

	public Usuario salvar(Usuario usuario) {
		String novaSenha = geradorSenha.gerarSenha(usuario.getSenha());
		usuario.setSenha(novaSenha);
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalvo = buscarUsuarioExistente(codigo);
		String novaSenha = geradorSenha.gerarSenha(usuario.getSenha());
		usuario.setSenha(novaSenha);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");

		return usuarioRepository.save(usuarioSalvo);
	}



	private Usuario buscarUsuarioExistente(Long codigo) {
		return usuarioRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException());
	}	
	
}
