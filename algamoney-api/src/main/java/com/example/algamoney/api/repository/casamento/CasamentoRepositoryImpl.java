package com.example.algamoney.api.repository.casamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import com.example.algamoney.api.model.Casamento;
import com.example.algamoney.api.model.Casamento_;
import com.example.algamoney.api.model.Categoria_;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Lancamento_;
import com.example.algamoney.api.model.Pessoa_;
import com.example.algamoney.api.repository.filter.CasamentoFilter;
import com.example.algamoney.api.repository.filter.LancamentoFilter;
import com.example.algamoney.api.repository.projection.ResumoLancamento;



public class CasamentoRepositoryImpl implements CasamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	public Page<Casamento> filtrar(CasamentoFilter casamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Casamento> criteria = builder.createQuery(Casamento.class);
		Root<Casamento> root = criteria.from(Casamento.class);
		
		Predicate[] predicates = criarRestricoes(casamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Casamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(casamentoFilter));
	}

	private Predicate[] criarRestricoes(CasamentoFilter casamentoFilter, CriteriaBuilder builder,
			Root<Casamento> root) {
		
		List<Predicate> predicates = new ArrayList<>();
				
		if(!ObjectUtils.isEmpty(casamentoFilter.getNomeNoivo())) {
			predicates.add(builder.like(
					builder.lower(root.get(Casamento_.nomeNoivo)), "%" + casamentoFilter.getNomeNoivo().toLowerCase() + "%"));
		}
		
		if((casamentoFilter.getLocalizacao()!=null)) {
			predicates.add(builder.equal(root.get(Casamento_.localizacao), casamentoFilter.getLocalizacao().getCodigo()));
		}
		
		if(!ObjectUtils.isEmpty(casamentoFilter.getNomeNoiva())) {
			predicates.add(builder.like(
					builder.lower(root.get(Casamento_.nomeNoiva)), "%" + casamentoFilter.getNomeNoiva().toLowerCase() + "%"));
		}
		
		if(!ObjectUtils.isEmpty(casamentoFilter.getPaisNoivo())) {
			predicates.add(builder.like(
					builder.lower(root.get(Casamento_.paisNoivo)), "%" + casamentoFilter.getPaisNoivo().toLowerCase() + "%"));
		}
		
		if(!ObjectUtils.isEmpty(casamentoFilter.getPaisNoiva())) {
			predicates.add(builder.like(
					builder.lower(root.get(Casamento_.paisNoiva)), "%" + casamentoFilter.getPaisNoiva().toLowerCase() + "%"));
		}
		
		if(!ObjectUtils.isEmpty(casamentoFilter.getTestemunhas())) {
			predicates.add(builder.like(
					builder.lower(root.get(Casamento_.testemunhas)), "%" + casamentoFilter.getTestemunhas().toLowerCase() + "%"));
		}
		
		if (casamentoFilter.getDataCasamentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(Casamento_.dataCasamento), casamentoFilter.getDataCasamentoDe()));
		}
		
		if (casamentoFilter.getDataCasamentoAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get(Casamento_.dataCasamento), casamentoFilter.getDataCasamentoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	/*@Override
	public Page<ResumoLancamento> resumir(CasamentoFilter casamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamento> criteria = builder.createQuery(ResumoLancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		criteria.select(builder.construct(ResumoLancamento.class
				, root.get(Lancamento_.codigo), root.get(Lancamento_.descricao)
				, root.get(Lancamento_.dataVencimento), root.get(Lancamento_.dataPagamento)
				, root.get(Lancamento_.valor), root.get(Lancamento_.tipo)
				, root.get(Lancamento_.categoria).get(Categoria_.nome)
				, root.get(Lancamento_.pessoa).get(Pessoa_.nome)));
		
		Predicate[] predicates = criarRestricoes(casamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoLancamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}*/
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(CasamentoFilter casamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Casamento> root = criteria.from(Casamento.class);
		
		Predicate[] predicates = criarRestricoes(casamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}
