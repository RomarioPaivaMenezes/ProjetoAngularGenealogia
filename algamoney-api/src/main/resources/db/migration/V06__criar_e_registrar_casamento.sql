CREATE TABLE casamento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome_noivo VARCHAR(200) NOT NULL,
    nome_noiva VARCHAR(200) NOT NULL,
    pais_noivo VARCHAR(200) NOT NULL,
    pais_noiva VARCHAR(200) NOT NULL,
    testemunhas VARCHAR(200) NOT NULL,
    codigo_localizacao BIGINT(20) NOT NULL,
	data_casamento DATE NOT NULL,
	observacao VARCHAR(300),
	FOREIGN KEY (codigo_localizacao) REFERENCES localizacao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

