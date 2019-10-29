-- Escrever uma consulta que retorne todos os produtos com quantidade maior ou igual a 100--

SELECT  descricao, quantidade, sequencial, codbarras from produto
INNER JOIN estoque
ON produto.codigo = estoque.produto_codigo
where quantidade >= 100;

-- Escrever uma consulta que traga todos os produtos que têm estoque para a filial de código 60

SELECT  descricao, quantidade, sequencial, codbarras, filial_codigo from produto
INNER JOIN estoque
ON produto.codigo = estoque.produto_codigo
where filial_codigo = 60;

-- Escrever consulta que liste todos os campos para o domínio PedidoEstoque e
-- ItensPedido filtrando apenas o produto de código 7993

select *from pedido_estoque
inner join  itens_pedido 
on pedido_estoque.codigo = itens_pedido.pedidoestoque_codigo
where itens_pedido.produto_codigo = 7993;

-- Escrever uma consulta que liste os pedidos com suas respectivas formas de pagamento.

select *from pedido_estoque
inner join  itens_pedido 
on pedido_estoque.formapagamento_codigo = itens_pedido.codigo
inner join forma_pagamento
on pedido_estoque.formapagamento_codigo = forma_pagamento.codigo


-- Escrever um consulta para sumarizar e bater os valores da capa do pedido com os
-- valores dos ítens de pedido


-- Escrever uma consulta para sumarizar o total dos itens por pedido e que filtre
-- apenas os pedidos no qual a soma total da quantidade de ítens de pedido seja maior
-- que 10
