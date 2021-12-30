CREATE TABLE localizacao (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO localizacao (nome, cidade, estado, ativo) values ('Capela da Serra do Martins', 'Martins', 'RN', true);
INSERT INTO localizacao (nome, cidade, estado, ativo) values ('Capela Catolé', 'Catolé do Rocha', 'RN', true);
