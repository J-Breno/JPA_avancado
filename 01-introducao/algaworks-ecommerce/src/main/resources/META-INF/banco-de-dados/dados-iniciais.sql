INSERT INTO produto(id, nome, preco, descricao) VALUES (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com novas atualizações');
INSERT INTO produto(id, nome, preco, descricao) VALUES (3, 'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor que o anterior');

INSERT INTO cliente (id, nome) VALUES (1, 'João Breno');
INSERT INTO cliente (id, nome) VALUES (2, 'Souza Melo');

INSERT INTO pedido (id, cliente_id, data_pedido, total, status) VALUES (1, 1, '2025-03-04 12:00:00', 2, 'AGUARDANDO');
INSERT INTO item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) VALUES (1, 1, 1, 400, 1);