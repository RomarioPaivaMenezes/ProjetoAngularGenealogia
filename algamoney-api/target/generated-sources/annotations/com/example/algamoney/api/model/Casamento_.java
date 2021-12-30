package com.example.algamoney.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Casamento.class)
public abstract class Casamento_ {

	public static volatile SingularAttribute<Casamento, String> nomeNoiva;
	public static volatile SingularAttribute<Casamento, Long> codigo;
	public static volatile SingularAttribute<Casamento, String> nomeNoivo;
	public static volatile SingularAttribute<Casamento, String> observacao;
	public static volatile SingularAttribute<Casamento, Localizacao> localizacao;
	public static volatile SingularAttribute<Casamento, String> paisNoiva;
	public static volatile SingularAttribute<Casamento, String> paisNoivo;
	public static volatile SingularAttribute<Casamento, LocalDate> dataCasamento;
	public static volatile SingularAttribute<Casamento, String> testemunhas;

	public static final String NOME_NOIVA = "nomeNoiva";
	public static final String CODIGO = "codigo";
	public static final String NOME_NOIVO = "nomeNoivo";
	public static final String OBSERVACAO = "observacao";
	public static final String LOCALIZACAO = "localizacao";
	public static final String PAIS_NOIVA = "paisNoiva";
	public static final String PAIS_NOIVO = "paisNoivo";
	public static final String DATA_CASAMENTO = "dataCasamento";
	public static final String TESTEMUNHAS = "testemunhas";

}

