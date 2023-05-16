-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 16/05/2023 às 22:43
-- Versão do servidor: 10.6.12-MariaDB-cll-lve
-- Versão do PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `u820047759_unisul_teste`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_amigos`
--

CREATE TABLE `tb_amigos` (
  `id` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `telefone` bigint(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_emprestimos`
--

CREATE TABLE `tb_emprestimos` (
  `id` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `finalizado` tinyint(1) NOT NULL,
  `valor_receber` bigint(22) NOT NULL,
  `amigo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_enderecos`
--

CREATE TABLE `tb_enderecos` (
  `amigo_id` int(11) NOT NULL,
  `numero` int(8) NOT NULL,
  `rua` varchar(128) NOT NULL,
  `bairro` varchar(128) NOT NULL,
  `cidade` varchar(64) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `cep` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_fabricantes`
--

CREATE TABLE `tb_fabricantes` (
  `id` int(11) NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  `cnpj` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_ferramentas`
--

CREATE TABLE `tb_ferramentas` (
  `id` int(22) NOT NULL,
  `name` varchar(22) NOT NULL,
  `price` double NOT NULL,
  `fabricante_id` int(11) DEFAULT NULL,
  `emprestimo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_amigos`
--
ALTER TABLE `tb_amigos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices de tabela `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `amigo_id` (`amigo_id`);

--
-- Índices de tabela `tb_enderecos`
--
ALTER TABLE `tb_enderecos`
  ADD UNIQUE KEY `amigo_id` (`amigo_id`);

--
-- Índices de tabela `tb_fabricantes`
--
ALTER TABLE `tb_fabricantes`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fabricante_id` (`fabricante_id`),
  ADD KEY `emprestimo_id` (`emprestimo_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_amigos`
--
ALTER TABLE `tb_amigos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tb_fabricantes`
--
ALTER TABLE `tb_fabricantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  MODIFY `id` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  ADD CONSTRAINT `tb_emprestimos_ibfk_1` FOREIGN KEY (`amigo_id`) REFERENCES `tb_amigos` (`id`);

--
-- Restrições para tabelas `tb_enderecos`
--
ALTER TABLE `tb_enderecos`
  ADD CONSTRAINT `tb_enderecos_ibfk_1` FOREIGN KEY (`amigo_id`) REFERENCES `tb_amigos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  ADD CONSTRAINT `tb_ferramentas_ibfk_2` FOREIGN KEY (`emprestimo_id`) REFERENCES `tb_emprestimos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_ferramentas_ibfk_3` FOREIGN KEY (`fabricante_id`) REFERENCES `tb_fabricantes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
