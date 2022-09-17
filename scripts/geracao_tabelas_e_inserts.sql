drop database if exists rotten_potatoes ;

create database rotten_potatoes;

use rotten_potatoes;

drop table if exists recomendacao_espectador_livro;

drop table if exists avaliacao_espectador_filme;

drop table if exists avaliacao_espectador_seriado;

drop table if exists avaliacao_critica_seriado;

drop table if exists avaliacao_critica_filme;

drop table if exists atuacao_serie;

drop table if exists atuacao_filme;

drop table if exists ator ;

drop table if exists ator_filme ;

drop table if exists avaliacao_critica ;

drop table if exists critico ;

drop table if exists diretor ;

drop table if exists estudio ;

drop table if exists filme ;

drop table if exists seriado ;


-- diretor
create table diretor (
                         id           integer auto_increment not null,
                         nome varchar(200) not null,
                         aniversario date not null,
                         naturalidade varchar(100) not null,
                         primary key (id)
);

-- estudio
create table  estudio (
                          id           integer auto_increment not null,
                          nome varchar(200) not null,
                          pais varchar(200) null,
                          presidente varchar(200) null,
                          primary key (id)
);

-- ator
create table  ator (
                       id           integer auto_increment not null,
                       nome varchar(200) not null,
                       aniversario date not null,
                       naturalidade varchar(200) not null,
                       biografia text,
                       altura float not null,
                       primary key (id)
);


-- seriado
create table  seriado (
                          id           integer auto_increment not null,
                          titulo varchar(200) not null,
                          ano_estreia int not null,
                          sinopse varchar(1000),
                          pais_de_origem varchar(1000) not null,
                          temporadas int,
                          numero_de_episodios int,
                          capa blob,
                          bibliografiarecomendavel boolean,
                          primary key (id),
    -- chaves estrangeiras
                          id_diretor integer not null,
                          id_estudio integer not null,
                          foreign key (id_diretor) references diretor (id),
                          foreign key (id_estudio) references estudio (id)
);


-- filme
create table  filme (
                        id           integer auto_increment not null,
                        titulo varchar(50) not null,
                        ano_estreia int not null,
                        sinopse varchar(1000),
                        pais_de_origem varchar(100) not null,
                        classificacao int not null,
                        duracao int not null,
                        bilheteria int ,
                        capa blob,
                        recomendavel boolean,
                        primary key (id),
    -- chaves estrangeiras
                        id_diretor     integer ,
                        id_estudio     integer ,
                        foreign key (id_estudio) references estudio(id),
                        foreign key (id_diretor) references diretor(id)
);


-- escritor
create table  escritor (
                           nome varchar(200) not null,
                           aniversario date not null,
                           primary key (nome, aniversario)
);


-- gêneros literários (atributo multivalorado)
create table  generos_literarios (
                                     genero varchar(200) not null,
                                     escritor_nome varchar(200) not null,
                                     escritor_aniversario date not null,
                                     primary key (genero, escritor_nome, escritor_aniversario),
                                     foreign key (escritor_nome , escritor_aniversario) references escritor (nome , aniversario)
);


-- livro
create table  livro (
                        titulo varchar(200) not null,
                        ano int not null,
                        escritor_nome varchar(200) not null,
                        escritor_aniversario date not null,
                        primary key (titulo, escritor_nome, escritor_aniversario),
                        foreign key (escritor_nome , escritor_aniversario) references escritor (nome , aniversario)
);


create table espectador (
                            email varchar(320) not null,
                            nickname varchar(100) not null,
                            bio varchar(5000) null,
                            primary key (email)
);

create table  critico (
                          id           integer auto_increment,
                          nome varchar(200) not null,
                          aniversario date not null,
                          bibliografia varchar(5000),
                          revista varchar(5000) not null,
                          primary key (id)
);



-- -----------------------------------------------------
-- tabelas de relacionamentos
-- -----------------------------------------------------

create table  ator_seriado (
                               id_seriado integer not null,
                               id_ator integer not null,
                               primary key (id_seriado, id_ator),
                               foreign key (id_seriado) references seriado (id),
                               foreign key (id_ator) references ator (id)
);



create table  ator_filme (
                             id_filme integer not null,
                             id_ator integer not null,
                             primary key (id_filme, id_ator),
                             foreign key (id_filme) references filme (id),
                             foreign key (id_ator) references ator (id)
);



create table  avaliacao_critica_filme (
                                          id           integer not null auto_increment,
                                          id_filme integer not null,
                                          id_critico integer not null,
                                          nota int not null,
                                          descricao varchar(3000) not null,
                                          primary key (id),
                                          foreign key (id_filme) references filme (id),
                                          foreign key (id_critico) references critico (id)
);



create table  avaliacao_critica_seriado (
                                            id_seriado integer not null,
                                            id_critico integer not null,
                                            nota int not null,
                                            descrição varchar(3000) not null,
                                            primary key (id_seriado, id_critico),
                                            foreign key (id_seriado) references seriado (id),
                                            foreign key (id_critico) references critico (id)
);



create table  avaliacao_espectador_seriado (
                                               id_seriado integer not null,
                                               espectador_email varchar(200) not null,
                                               nota int not null,
                                               primary key (id_seriado, espectador_email),
                                               foreign key (id_seriado) references seriado (id),
                                               foreign key (espectador_email) references espectador (email)
);


create table  avaliacao_espectador_filme (
                                             id_filme integer not null,
                                             espectador_email varchar(200) not null,
                                             nota int not null,
                                             primary key (id_filme, espectador_email),
                                             foreign key (id_filme) references filme(id) on delete cascade,
                                             foreign key (espectador_email) references espectador (email)
);



create table  recomendacao_espectador_livro (
                                                livro_titulo varchar(200) not null,
                                                espectador_email varchar(200) not null,
                                                recomendacao boolean not null,
                                                primary key (livro_titulo, espectador_email),
                                                foreign key (livro_titulo) references livro (titulo),
                                                foreign key (espectador_email) references espectador (email)
);



-- -------------------------------------------------------
-- INSERÇÃO NAS TABELAS
-- -------------------------------------------------------

-- Atores
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('1', 'Robert John Downer Jr', '1965-05-04', 'EUA', null, 1.74);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('2', 'Christopher Robert Evans', '1981-06-13', 'EUA', null, 1.83);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('3', 'Matthew David McConaughey', '1969-11-04', 'EUA', null, 1.82);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('4', 'Michael Caine', '1933-03-14', 'Reino Unido', null, 1.88);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('5', 'Elizabeth Chase Olsen', '1989-02-16', 'EUA', null, 1.68);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('6', 'Scarlett Ingrid Johansson', '1984-11-22', 'EUA', null, 1.6);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('7', 'Grant Gustin', '1984-01-14', 'EUA', null, 1.7);
insert ator(id, nome, aniversario, naturalidade, biografia, altura) VALUES ('8', 'Cillian Murphy', '1976-05-25', 'Irlanda', null, 1.77);

-- Diretores
insert diretor(id, nome, aniversario, naturalidade) VALUES ('1', 'Christopher Nolan', '1970-07-30', 'Reino Unido');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('2', 'Joe Russo', '1971-07-18', 'EUA');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('3', 'Matt Shakman', '1975-08-08', 'EUA');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('4', 'Jonathan Kolia', '1966-10-19', 'EUA');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('5', 'Taika Waititi', '1975-08-16', 'Nova Zelândia');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('6', 'Andy Muschietti', '1973-08-26', 'Argentina');
insert diretor(id, nome, aniversario, naturalidade) VALUES ('7', 'Otto Bathurst', '1971-06-16', 'Reino Unido');

-- Estudios
insert estudio(id, nome, pais, presidente) VALUES ('1', 'Marvel Studios' , 'EUA', 'Kevin Feige');
insert estudio(id, nome, pais, presidente) VALUES ('2', 'Legendary Pictures', 'EUA', 'Thomas Tull');
insert estudio(id, nome, pais, presidente) VALUES ('3', '20th Century Studios', 'EUA', ' Joseph Schenck');
insert estudio(id, nome, pais, presidente) VALUES ('4', 'Warner Bros. Television Studios', 'EUA', ' David Zaslav'); 
insert estudio(id, nome, pais, presidente) VALUES ('5', 'BBC Studios', 'Inglaterra', ' Tim Davie'); 



-- Filmes
insert filme(id, titulo, ano_estreia, sinopse, pais_de_origem, classificacao, duracao, bilheteria, capa, id_diretor, id_estudio) VALUES ('1', 'Vingadores: Guerra Infinita', '2018', null, 'EUA', '12', '149', null, null, '2', '1');
insert filme(id, titulo, ano_estreia, sinopse, pais_de_origem, classificacao, duracao, bilheteria, capa, id_diretor, id_estudio) VALUES ('2', 'Interestelar', '2014', null, 'REINO UNIDO', '12', '169', null, null, '1', '2');
insert filme(id, titulo, ano_estreia, sinopse, pais_de_origem, classificacao, duracao, bilheteria, capa, id_diretor, id_estudio) VALUES ('3', 'Homem de Ferro 2', '2010', null, 'EUA', '12', '125', null, null, '4', '1');
insert filme(id, titulo, ano_estreia, sinopse, pais_de_origem, classificacao, duracao, bilheteria, capa, id_diretor, id_estudio) VALUES ('4', 'Jojo Rabbit', '2019', null, 'EUA', '14', '108', null, null, '5', '3');
insert filme(id, titulo, ano_estreia, sinopse, pais_de_origem, classificacao, duracao, bilheteria, capa, id_diretor, id_estudio) VALUES ('5', 'The Prestige', '2006', null, 'REINO UNIDO', '14', '130', null, null, '1', '4');


-- Seriados
insert seriado(id, titulo, ano_estreia, sinopse, pais_de_origem, temporadas, numero_de_episodios, capa, id_diretor, id_estudio) VALUES ('1','WandaVision', '2021', null, 'EUA', '1', '8', null, '3', '1' );
insert seriado(id, titulo, ano_estreia, sinopse, pais_de_origem, temporadas, numero_de_episodios, capa, id_diretor, id_estudio) VALUES ('2','The Flash', '2014', null, 'EUA', '7', '171', null, '6', '4' );
insert seriado(id, titulo, ano_estreia, sinopse, pais_de_origem, temporadas, numero_de_episodios, capa, id_diretor, id_estudio) VALUES ('3','Peaky Blinders', '2013', null, 'EUA', '6', '36', null, '7', '5' );

-- Relacao de Ator com Filmes 
insert ator_filme(id_filme, id_ator) VALUES ('1','1');
insert ator_filme(id_filme, id_ator) VALUES ('1','2');
insert ator_filme(id_filme, id_ator) VALUES ('1','5');
insert ator_filme(id_filme, id_ator) VALUES ('2','3');
insert ator_filme(id_filme, id_ator) VALUES ('2','4');
insert ator_filme(id_filme, id_ator) VALUES ('3','6');
insert ator_filme(id_filme, id_ator) VALUES ('3','1');
insert ator_filme(id_filme, id_ator) VALUES ('4','6');
insert ator_filme(id_filme, id_ator) VALUES ('5','6');
insert ator_filme(id_filme, id_ator) VALUES ('5','4');


-- Relacao de Atores com Seriados
insert ator_seriado(id_seriado, id_ator) VALUES ('1','5');
insert ator_seriado(id_seriado, id_ator) VALUES ('2','7');
insert ator_seriado(id_seriado, id_ator) VALUES ('3','8');


-- Espectadores
insert espectador(email, nickname, bio) VALUES ('lucas123@gmail.com', 'Lucas', 'gosto de filmes');
insert espectador(email, nickname, bio) VALUES ('luiza.magalhae@gmail.com', 'LuizaM', 'gosto de ficção');
insert espectador(email, nickname, bio) VALUES ('paulo.martins@gmail.com', 'Pmartins', 'curto séries');
insert espectador(email, nickname, bio) VALUES ('carla11@gmail.com', 'Cl', 'gosto tando de livros como de filmes');
insert espectador(email, nickname, bio) VALUES ('arturvinicios55@gmail.com', 'arturV', ':)');


-- Criticos
insert critico(id, nome, aniversario, bibliografia, revista) VALUES ('1', 'JAMES STARK','1990-10-11', null, 'BBC');
insert critico(id, nome, aniversario, bibliografia, revista) VALUES ('2', 'MILLER ROMEI','1970-04-21', null, 'The Australian');
insert critico(id, nome, aniversario, bibliografia, revista) VALUES ('3', 'ISIS KLEY','1990-10-11', null, 'OMELETE');
insert critico(id, nome, aniversario, bibliografia, revista) VALUES ('4', 'CARL NORRIS','1970-04-21', null, 'The New York');
	
-- Avaliações de Usuarios a Filmes
insert avaliacao_espectador_filme(id_filme , espectador_email, nota) VALUES ('2','lucas123@gmail.com', '6');
insert avaliacao_espectador_filme(id_filme, espectador_email, nota) VALUES ('1', 'luiza.magalhae@gmail.com', '9');
insert avaliacao_espectador_filme(id_filme, espectador_email, nota) VALUES ('3', 'luiza.magalhae@gmail.com', '4');
insert avaliacao_espectador_filme(id_filme, espectador_email, nota) VALUES ('3', 'paulo.martins@gmail.com', '6');
insert avaliacao_espectador_filme(id_filme, espectador_email, nota) VALUES ('3', 'carla11@gmail.com', '10');

-- Avaliações de Usuarios a Seriados
insert avaliacao_espectador_seriado(id_seriado , espectador_email, nota) VALUES ('1','lucas123@gmail.com', '9');
insert avaliacao_espectador_seriado(id_seriado, espectador_email, nota) VALUES ('1', 'luiza.magalhae@gmail.com', '8');
insert avaliacao_espectador_seriado(id_seriado, espectador_email, nota) VALUES ('3', 'paulo.martins@gmail.com', '10');
insert avaliacao_espectador_seriado(id_seriado, espectador_email, nota) VALUES ('2', 'paulo.martins@gmail.com', '5');
insert avaliacao_espectador_seriado(id_seriado, espectador_email, nota) VALUES ('3', 'luiza.magalhae@gmail.com', '10');
insert avaliacao_espectador_seriado(id_seriado, espectador_email, nota) VALUES ('2', 'luiza.magalhae@gmail.com', '6');

-- Avaliações Criticas a Filmes
insert avaliacao_critica_filme(id, id_filme, id_critico, nota, descricao) VALUES (null ,1,'1', '9',"Eleven years of Universe building, and this is the crescendo. It really pays off, I've never seen anything quite like it." );
insert avaliacao_critica_filme(id, id_filme, id_critico, nota, descricao) VALUES ( null ,2, 2, '6', "t is this part of the story, the human side, to narrow it down to our marginal planet, that holds the movie together for its three-hour run time.");
insert avaliacao_critica_filme(id, id_filme, id_critico, nota, descricao) VALUES ( null ,3, 3, '6', "annoying");
insert avaliacao_critica_filme(id, id_filme, id_critico, nota, descricao) VALUES ( null ,4, 4, '9', "deep");
insert avaliacao_critica_filme(id, id_filme, id_critico, nota, descricao) VALUES ( null ,5, 1, '7', "fascinating");


-- Avaliações Criticas a Seriados
insert avaliacao_critica_seriado(id_seriado, id_critico, nota, descrição) VALUES ('1','1', '7', 'Reasonably Fun');
insert avaliacao_critica_seriado( id_seriado, id_critico, nota, descrição) VALUES ('1', '2', '3', "Confused");
insert avaliacao_critica_seriado(id_seriado, id_critico, nota, descrição) VALUES ('3', '3', '10', "Inspiring");
insert avaliacao_critica_seriado(id_seriado, id_critico, nota, descrição) VALUES ('2', '4', '4', "a lot of stalling");

-- view
drop view if exists avaliacoes;
create view avaliacoes as
select descricao,
       nota,
       recomendavel,
       c.nome as critico,
       revista,
       f.titulo,
       ano_estreia,
       sinopse,
       pais_de_origem,
       classificacao,
       duracao,
       bilheteria,
       e.nome as estudio,
       e.pais,
       e.presidente
from avaliacao_critica_filme
         join filme f on avaliacao_critica_filme.id_filme = f.id
         join critico c on c.id = avaliacao_critica_filme.id_critico
         join diretor d on d.id = f.id_diretor
         join estudio e on f.id_estudio = e.id
order by nota desc;

drop view if exists filmes;
create view filmes as
select *
from filme

-- procedure
         DELIMITER //

CREATE PROCEDURE is_recomendavel()
BEGIN
    if exists(select *
              from filme
                       join avaliacao_critica_filme acf on filme.id = acf.id_filme) then
        SET SQL_SAFE_UPDATES = 0;
        UPDATE filme
            join avaliacao_critica_filme acf on filme.id = acf.id_filme
        SET recomendavel = CASE
                               WHEN acf.nota >= 8 THEN true
                               WHEN acf.nota < 8 THEN false
            END;
        SET SQL_SAFE_UPDATES = 1;
    end if;
END //

DELIMITER ;

