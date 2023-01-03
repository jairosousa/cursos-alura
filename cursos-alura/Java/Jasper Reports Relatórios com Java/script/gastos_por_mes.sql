SELECT
     categorias.`nome` AS categoriaNome,
     movimentacoes.`id` AS id,
     movimentacoes.`data` AS data,
     movimentacoes.`descricao` AS descricao,
     movimentacoes.`tipoMovimentacao` AS tipo,
     movimentacoes.`valor` AS valor,
     contas.`titular` AS contaTitular
FROM
     `categorias` categorias INNER JOIN `movimentacoes` movimentacoes ON categorias.`id` = movimentacoes.`categoria_id`
     INNER JOIN `contas` contas ON movimentacoes.`conta_id` = contas.`id`
WHERE
     tipoMovimentacao LIKE 'SAIDA'
GROUP BY
     contaTitular
ORDER BY
     contas.`titular` ASC,
     movimentacoes.`data` ASC