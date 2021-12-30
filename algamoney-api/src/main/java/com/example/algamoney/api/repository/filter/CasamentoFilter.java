package com.example.algamoney.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.algamoney.api.model.Localizacao;

public class CasamentoFilter {
    
	private String nomeNoivo;
	
	private String nomeNoiva;
	
	private String paisNoivo;
	
	private String paisNoiva;
	
	private String testemunhas;
	
	private Localizacao localizacao;
	
	
	


	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCasamentoDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCasamentoAte;

	public String getNomeNoivo() {
		return nomeNoivo;
	}

	public void setNomeNoivo(String nomeNoivo) {
		this.nomeNoivo = nomeNoivo;
	}

	public LocalDate getDataCasamentoDe() {
		return dataCasamentoDe;
	}

	public void setDataCasamentoDe(LocalDate dataCasamentoDe) {
		this.dataCasamentoDe = dataCasamentoDe;
	}

	public LocalDate getDataCasamentoAte() {
		return dataCasamentoAte;
	}

	public void setDataCasamentoAte(LocalDate dataCasamentoAte) {
		this.dataCasamentoAte = dataCasamentoAte;
	}

	public String getNomeNoiva() {
		return nomeNoiva;
	}

	public void setNomeNoiva(String nomeNoiva) {
		this.nomeNoiva = nomeNoiva;
	}

	public String getPaisNoivo() {
		return paisNoivo;
	}

	public void setPaisNoivo(String paisNoivo) {
		this.paisNoivo = paisNoivo;
	}

	public String getPaisNoiva() {
		return paisNoiva;
	}

	public void setPaisNoiva(String paisNoiva) {
		this.paisNoiva = paisNoiva;
	}

	public String getTestemunhas() {
		return testemunhas;
	}

	public void setTestemunhas(String testemunhas) {
		this.testemunhas = testemunhas;
	}

	
	
	
}
