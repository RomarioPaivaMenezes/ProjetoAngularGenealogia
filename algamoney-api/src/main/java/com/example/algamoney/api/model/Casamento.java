package com.example.algamoney.api.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "casamento")
public class Casamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String nomeNoivo;
	
	@NotNull
	private String nomeNoiva;
	
	@NotNull
	private String paisNoivo;
	
	@NotNull
	private String paisNoiva;
	
	@NotNull
	private String testemunhas;
	
	@ManyToOne
	@JoinColumn(name = "codigo_localizacao")
	Localizacao localizacao;
	
	@NotNull
	@Column(name = "data_casamento")
	private LocalDate dataCasamento;

	@NotNull
	String observacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeNoivo() {
		return nomeNoivo;
	}

	public void setNomeNoivo(String nomeNoivo) {
		this.nomeNoivo = nomeNoivo;
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

	
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public LocalDate getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(LocalDate dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casamento other = (Casamento) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
