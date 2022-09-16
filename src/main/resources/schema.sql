
drop database if exists rotten_potatoes ;

create database rotten_potatoes;

use rotten_potatoes;

drop table if exists ator ;

drop table if exists ator_filme ;

drop table if exists avaliacao_critica ;

drop table if exists critico ;

drop table if exists diretor ;

drop table if exists estudio ;

drop table if exists filme ;

drop table if exists seriado ;

create table ator
(
    id           integer,
    altura       decimal(19, 2),
    aniversario  timestamp,
    biografia    varchar(255),
    naturalidade varchar(255),
    nome         varchar(255),
    primary key (id)
);






create table diretor
(
    id           integer auto_increment,
    aniversario  date,
    naturalidade varchar(255),
    nome         varchar(255),
    primary key (id)
);

create table estudio
(
    id           integer auto_increment,
    ano_fundacao integer,
    nome         varchar(255),
    pais         varchar(255),
    presidente   varchar(255),
    primary key (id)
);

create table filme
(
    id             integer auto_increment,
    ano_estreia    integer,
    bilheteria     varchar(255),
    classificao    varchar(255),
    duracao        time,
    pais_de_origem varchar(255),
    sinopse        varchar(255),
    titulo         varchar(255),
    id_diretor     integer not null,
    id_estudio     integer not null,
    primary key (id),
    constraint fk_estudio_filme
        foreign key (id_estudio)
            references estudio(id),
    constraint fk_diretor_filme
        foreign key (id_diretor)
            references diretor(id)
);

create table avaliacao_critica
(
    id        integer auto_increment,
    descricao varchar(255),
    nota      integer,
    revista   varchar(255),
    id_filme  integer not null,
    primary key (id),
    constraint
        foreign key (id_filme)
            references filme(id)
);

create table critico
(
    id           integer auto_increment,
    aniversario  date,
    bibliografia varchar(255),
    nome         varchar(255),
    publicacoes  varchar(255),
    id_avaliacao integer,
    primary key (id),
    constraint
        foreign key (id_avaliacao)
            references avaliacao_critica(id)
);

create table ator_filme
(
    id_filme integer not null,
    id_ator   integer not null,
    constraint
        foreign key (id_filme)
            references filme(id),
    constraint
        foreign key (id_ator)
            references ator(id)
);

create table seriado
(
    id             integer auto_increment,
    ano_estreia    integer,
    classificao    varchar(255),
    name           varchar(255),
    pais_de_origem varchar(255),
    sinopse        varchar(255),
    temporadas     integer,
    titulo         varchar(255),
    primary key (id)
);







