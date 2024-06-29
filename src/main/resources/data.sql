INSERT INTO Cliente (nome, email) VALUES
('Cliente 1', 'cliente1@example.com'),
('Cliente 2', 'cliente2@example.com'),
('Cliente 3', 'cliente3@example.com'),
('Cliente 4', 'cliente4@example.com'),
('Cliente 5', 'cliente5@example.com'),
('Cliente 6', 'cliente6@example.com'),
('Cliente 7', 'cliente7@example.com'),
('Cliente 8', 'cliente8@example.com'),
('Cliente 9', 'cliente9@example.com'),
('Cliente 10', 'cliente10@example.com');

INSERT INTO Aplicativo (nome, custo_mensal) VALUES
('Aplicativo 1', 10.00),
('Aplicativo 2', 20.00),
('Aplicativo 3', 30.00),
('Aplicativo 4', 40.00),
('Aplicativo 5', 50.00),
('Aplicativo 6', 60.00),
('Aplicativo 7', 70.00),
('Aplicativo 8', 80.00),
('Aplicativo 9', 90.00),
('Aplicativo 10', 100.00);

INSERT INTO Assinatura (aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia) VALUES
(1, 1, '2024-05-01', '2024-05-08'),   -- 7 dias de diferença
(2, 2, '2024-05-12', '2024-06-14'),  -- 30 dias de diferença
(3, 3, '2024-02-01', '2024-03-30'),  -- 29 dias de diferença
(4, 4, '2024-01-15', '2024-04-14'),  -- 29 dias de diferença
(5, 5, '2024-05-01', '2024-08-30'),  -- 60 dias de diferença
(1, 6, '2024-05-10', '2024-08-17'),  -- 30 dias de diferença
(2, 7, '2024-04-01', '2024-05-01'),  -- 29 dias de diferença
(3, 8, '2024-04-15', '2024-05-14'),  -- 30 dias de diferença
(4, 9, '2024-05-01', '2024-09-30'),  -- 29 dias de diferença
(5, 10, '2024-03-08', '2024-05-08'), -- 29 dias de diferença
(1, 1, '2024-05-01', '2024-05-08'),   -- 7 dias de diferença
(2, 2, '2024-05-10', '2024-06-17'),  -- 30 dias de diferença
(3, 3, '2024-05-01', '2024-06-30'),  -- 29 dias de diferença
(4, 4, '2024-05-15', '2024-07-14'),  -- 29 dias de diferença
(5, 5, '2024-03-01', '2024-04-30'),  -- 60 dias de diferença
(10, 6, '2024-01-15', '2024-03-14'),  -- 30 dias de diferença
(9, 7, '2024-03-01', '2024-04-30'),  -- 29 dias de diferença
(8, 8, '2024-02-15', '2024-03-14'),  -- 30 dias de diferença
(7, 9, '2024-05-02', '2024-05-30'),  -- 29 dias de diferença
(6, 10, '2024-04-28', '2024-10-14'); -- 29 dias de diferença

