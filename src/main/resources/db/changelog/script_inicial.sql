--liquibase formatted sql
--changeset lucianoornelas:1


CREATE SEQUENCE seq_tb_usuarios;
CREATE TABLE tb_usuarios (
 id_usu integer CONSTRAINT pk_id_usu PRIMARY KEY,
 nome_usu varchar(50)  NOT NULL,
 login_usu varchar(20)  NOT NULL,
 senha_usu varchar(200)  NOT NULL,
 data_criacao_usu timestamp NOT NULL
);

CREATE SEQUENCE seq_tb_postagens;
CREATE TABLE tb_postagens (
 id_post integer CONSTRAINT pk_id_post PRIMARY KEY,
 id_usu_post integer NOT NULL,
 texto_post text NOT NULL,
 data_criacao_post timestamp NOT NULL,
  FOREIGN KEY (id_usu_post) REFERENCES tb_usuarios (id_usu) ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_fotos;
CREATE TABLE tb_fotos (
 id_fto integer CONSTRAINT pk_id_fto PRIMARY KEY,
 id_usu_fto integer NOT NULL,
 id_post_fto integer NULL,
 link_fto varchar(200)  NOT NULL,
 data_criacao_fto timestamp NOT NULL,
  FOREIGN KEY (id_usu_fto) REFERENCES tb_usuarios (id_usu) ON DELETE CASCADE,
  FOREIGN KEY (id_post_fto) REFERENCES tb_postagens (id_post) ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_comentarios;
CREATE TABLE tb_comentarios (
 id_cmt integer CONSTRAINT pk_id_cmt PRIMARY KEY,
 id_usu_cmt integer NOT NULL,
 id_post_cmt integer NOT NULL,
 data_criacao_cmt timestamp NOT NULL,
 texto_cmt text,
 FOREIGN KEY (id_usu_cmt) REFERENCES tb_usuarios (id_usu) ON DELETE CASCADE,
 FOREIGN KEY (id_post_cmt) REFERENCES tb_postagens (id_post) ON DELETE CASCADE
);

