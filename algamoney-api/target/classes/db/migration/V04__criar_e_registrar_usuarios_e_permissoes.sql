CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');
INSERT INTO usuario (codigo, nome, email, senha) values (3, 'Marcella', 'marcella@gmail.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (codigo, nome, email, senha) values (4, 'Romário Paiva', 'romarioinf@gmail.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');


INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_CASAMENTO');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_REMOVER_CASAMENTO');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_PESQUISAR_CASAMENTO');

INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_CADASTRAR_BATISMO');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_REMOVER_BATISMO');
INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_PESQUISAR_BATISMO');

INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_CADASTRAR_OBITO');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_REMOVER_OBITO');
INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_PESQUISAR_OBITO');

INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_CADASTRAR_LOCAL');
INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_REMOVER_LOCAL');
INSERT INTO permissao (codigo, descricao) values (12, 'ROLE_PESQUISAR_LOCAL');

INSERT INTO permissao (codigo, descricao) values (13, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO permissao (codigo, descricao) values (14, 'ROLE_REMOVER_PESSOA');
INSERT INTO permissao (codigo, descricao) values (15, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO permissao (codigo, descricao) values (16, 'ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (17, 'ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (18, 'ROLE_REMOVER_USUARIO');


-- Romario
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 15);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 16);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 17);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (4, 18);


-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);

-- marcella
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 8);