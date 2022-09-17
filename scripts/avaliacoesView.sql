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