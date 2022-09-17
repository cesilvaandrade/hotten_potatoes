DELIMITER //

CREATE PROCEDURE is_recomedavel()
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