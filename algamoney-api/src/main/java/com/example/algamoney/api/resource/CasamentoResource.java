package com.example.algamoney.api.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.exceptionHandler.AlgamoneyExceptionHandler.Erro;
import com.example.algamoney.api.model.Casamento;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.CasamentoRepository;
import com.example.algamoney.api.repository.filter.CasamentoFilter;
import com.example.algamoney.api.service.CasamentoService;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@RestController
@RequestMapping("/casamentos")
public class CasamentoResource {

	@Autowired
	private CasamentoRepository casamentoRepository;
		
	@Autowired
	private CasamentoService casamentoService;

	@Autowired
	private ApplicationEventPublisher publisher;
    
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CASAMENTO') and hasAuthority('SCOPE_read')")
	public Page<Casamento> pesquisar(CasamentoFilter casamentoFilter, Pageable pageable) {
		return casamentoRepository.filtrar(casamentoFilter, pageable);
	}
		
    /*@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return casamentoRepository.resumir(lancamentoFilter, pageable);
	}*/
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CASAMENTO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Casamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Casamento> casamento = casamentoRepository.findById(codigo);
		return casamento.isPresent() ? ResponseEntity.ok(casamento.get()) : ResponseEntity.notFound().build();
	}
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CASAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Casamento> criar(@Valid @RequestBody Casamento casamento, HttpServletResponse response) {
		Casamento casamentoSalvo = casamentoService.salvar(casamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, casamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(casamentoSalvo);
	}
		
	@ExceptionHandler({ PessoaInexistenteOuInativaException.class })
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CASAMENTO') and hasAuthority('SCOPE_write')")
	public void remover(@PathVariable Long codigo) {
		casamentoRepository.deleteById(codigo);
	}

		
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CASAMENTO')")
	public ResponseEntity<Casamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Casamento casamento) {
		try {
			Casamento casamentoSalvo = casamentoService.atualizar(codigo, casamento);
			return ResponseEntity.ok(casamentoSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
