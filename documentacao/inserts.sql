INSERT INTO `dbithappens1303`.`usuario` (`cpf`, `email`, `nome`) VALUES ('85858558', 'ka@gmail.com', 'karina');
INSERT INTO `dbithappens1303`.`usuario` (`cpf`, `email`, `nome`) VALUES ('56565', 'm@mail.com', 'silva');


INSERT INTO `dbithappens1303`.`cliente` (`cnpj`, `nome`, `telefone`) VALUES ('45454545', 'Gildean', '834374');
INSERT INTO `dbithappens1303`.`cliente` (`cnpj`, `nome`, `telefone`) VALUES ('34736437', 'Macio', '38473');


INSERT INTO `dbithappens1303`.`filial` (`bairro`, `cidade`, `estado`, `nome`, `numero`, `rua`, `telefone`) VALUES ('Res. Buriti', 'São Luís', 'MA', 'Mix Mateus', '21', 'Rua 1', '3473843');


INSERT INTO `dbithappens1303`.`produto` (`codbarras`, `descricao`, `sequencial`) VALUES ('4545454', 'arroz tipo 1', '34837483');

INSERT INTO `dbithappens1303`.`pedido_estoque` (`observacao`, `tipo`, `valortotal`, `cliente_codigo`, `filial_codigo`, `usuario_codigo`) VALUES ('Manter a -5°', '1', '455', '1', '1', '1');

INSERT INTO `dbithappens1303`.`pedido_estoque` (`observacao`, `tipo`, `valortotal`, `cliente_codigo`, `filial_codigo`, `usuario_codigo`) VALUES ('Levar a -5°', '1', '100', '1', '1', '2');

INSERT INTO `dbithappens1303`.`pedido_estoque` (`observacao`, `tipo`, `valortotal`, `cliente_codigo`, `filial_codigo`, `usuario_codigo`) VALUES ('Levar a -5°', '1', '100', '1', '1', '2');

INSERT INTO `dbithappens1303`.`produto` (`codigo`, `codbarras`, `descricao`, `sequencial`) VALUES ('2', '34343', 'Feijão tipo 2', '348347384');

INSERT INTO `dbithappens1303`.`filial` (`codigo`, `bairro`, `cidade`, `estado`, `nome`, `numero`, `rua`, `telefone`) VALUES ('2', 'Res. Estrela', 'São José de Ribamar', 'MA', 'Mix Atacarejo', '32', 'Rua 4', '3483483');

INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('30', '1', '1');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('100', '2', '1');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('3444', '2', '1');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('2', '2', '1');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('140', '1', '2');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('1', '1', '2');
INSERT INTO `dbithappens1303`.`estoque` (`quantidade`, `filial_codigo`, `produto_codigo`) VALUES ('2', '1', '2');

INSERT INTO `dbithappens1303`.`filial` (`codigo`, `bairro`, `cidade`, `estado`, `nome`, `numero`, `rua`, `telefone`) VALUES ('60', 'Rua da Estrela', 'São Paulo', 'SP', 'Mateus', '32', 'Rua 233', '443343');

INSERT INTO `dbithappens1303`.`produto` (`codbarras`, `descricao`, `sequencial`) VALUES ('4545454', 'Farinha', '232323323');

INSERT INTO `dbithappens1303`.`produto` (`codigo`, `codbarras`, `descricao`, `sequencial`) VALUES ('7993', '5678787', 'Leite condensado', '856958994');
INSERT INTO `dbithappens1303`.`pedido_estoque` (`observacao`, `tipo`, `valortotal`, `cliente_codigo`, `filial_codigo`, `usuario_codigo`) VALUES ('Conservar a -3°', '1', '232', '2', '2', '2');
INSERT INTO `dbithappens1303`.`itens_pedido` (`quantidade`, `valorunitario`, `pedidoestoque_codigo`, `produto_codigo`) VALUES ('11', '232', '1', '7993');
INSERT INTO `dbithappens1303`.`itens_pedido` (`quantidade`, `valorunitario`, `pedidoestoque_codigo`, `produto_codigo`) VALUES ('2', '34', '1', '7993');
INSERT INTO `dbithappens1303`.`forma_pagamento` (`tipo`) VALUES ('crédito');
INSERT INTO `dbithappens1303`.`forma_pagamento` (`tipo`) VALUES ('débito');
INSERT INTO `dbithappens1303`.`forma_pagamento` (`tipo`) VALUES ('á vista');
INSERT INTO `dbithappens1303`.`forma_pagamento` (`tipo`) VALUES ('boleto');

UPDATE `dbithappens1303`.`pedido_estoque` SET `formapagamento_codigo`='1' WHERE `codigo`='1';
UPDATE `dbithappens1303`.`pedido_estoque` SET `formapagamento_codigo`='2' WHERE `codigo`='2';
UPDATE `dbithappens1303`.`pedido_estoque` SET `formapagamento_codigo`='3' WHERE `codigo`='3';
UPDATE `dbithappens1303`.`pedido_estoque` SET `formapagamento_codigo`='2' WHERE `codigo`='4';



