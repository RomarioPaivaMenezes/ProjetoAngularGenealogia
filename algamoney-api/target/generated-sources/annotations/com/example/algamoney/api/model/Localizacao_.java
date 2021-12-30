package com.example.algamoney.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Localizacao.class)
public abstract class Localizacao_ {

	public static volatile SingularAttribute<Localizacao, Long> codigo;
	public static volatile SingularAttribute<Localizacao, String> cidade;
	public static volatile SingularAttribute<Localizacao, String> estado;
	public static volatile SingularAttribute<Localizacao, Boolean> ativo;
	public static volatile SingularAttribute<Localizacao, String> nome;

	public static final String CODIGO = "codigo";
	public static final String CIDADE = "cidade";
	public static final String ESTADO = "estado";
	public static final String ATIVO = "ativo";
	public static final String NOME = "nome";

}

