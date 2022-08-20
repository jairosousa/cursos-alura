SELECT DISTINCT BAIRRO FROM tabela_de_clientes WHERE CIDADE = 'Rio de Janeiro';

SELECT campos FROM tabela WHERE condicao LIMIT 5;

SELECT * FROM tabela_de_produtos;

-- Consulta LIMIT

SELECT * FROM tabela_de_produtos LIMIT 5;

SELECT * FROM tabela_de_produtos LIMIT 2,3;

SELECT * FROM tabela_de_produtos LIMIT 0,2;

SELECT * FROM notas_fiscais  WHERE DATA_VENDA = '2017-01-01' limit 10;

-- Consulta ORDER BY

SELECT * FROM tabela_de_produtos ORDER BY PRECO_DE_LISTA;

SELECT * FROM tabela_de_produtos ORDER BY PRECO_DE_LISTA DESC;

SELECT * FROM tabela_de_produtos ORDER BY NOME_DO_PRODUTO;

SELECT * FROM tabela_de_produtos ORDER BY NOME_DO_PRODUTO DESC;

SELECT * FROM tabela_de_produtos ORDER BY EMBALAGEM DESC, NOME_DO_PRODUTO ASC;

SELECT * FROM tabela_de_produtos ORDER BY PRECO_DE_LISTA DESC;

SELECT * FROM tabela_de_produtos ORDER BY NOME_DO_PRODUTO;

SELECT * FROM tabela_de_produtos ORDER BY NOME_DO_PRODUTO DESC;

SELECT * FROM tabela_de_produtos ORDER BY EMBALAGEM DESC, NOME_DO_PRODUTO ASC;

SELECT * FROM tabela_de_produtos WHERE nome_do_produto = 'Linha Refrescante - 1 Litro - Morango/Limão';

SELECT * FROM itens_notas_fiscais WHERE codigo_do_produto = '1101035' ORDER BY QUANTIDADE DESC;

-- Consulta GROUP BY

SELECT * FROM tabela_de_clientes;

SELECT ESTADO, LIMITE_DE_CREDITO FROM tabela_de_clientes;

SELECT ESTADO, SUM(LIMITE_DE_CREDITO) AS LIMITE_TOTAL FROM tabela_de_clientes GROUP BY ESTADO;

SELECT EMBALAGEM, PRECO_DE_LISTA FROM tabela_de_produtos;

SELECT EMBALAGEM, MAX(PRECO_DE_LISTA) AS MAIOR_PRECO FROM tabela_de_produtos GROUP BY EMBALAGEM;

