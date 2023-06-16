-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16/06/2023 às 22:01
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
  `amigo_id` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `previsaoDataEntrega` date NOT NULL,
  `dataFinalizado` date DEFAULT NULL,
  `valorEmprestimo` bigint(22) NOT NULL DEFAULT 0,
  `observacoes` text NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_fabricantes`
--

CREATE TABLE `tb_fabricantes` (
  `id` int(11) NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  `cnpj` varchar(14) NOT NULL DEFAULT '00000000000000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_ferramentas`
--

CREATE TABLE `tb_ferramentas` (
  `id` int(22) NOT NULL,
  `name` varchar(22) NOT NULL,
  `price` double NOT NULL,
  `fabricante_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_ferramentas_emprestimo`
--

CREATE TABLE `tb_ferramentas_emprestimo` (
  `emprestimo_id` int(11) NOT NULL,
  `ferramenta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_amigos`
--
ALTER TABLE `tb_amigos`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `amigo_id` (`amigo_id`);

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
  ADD KEY `fabricante_id` (`fabricante_id`);

--
-- Índices de tabela `tb_ferramentas_emprestimo`
--
ALTER TABLE `tb_ferramentas_emprestimo`
  ADD KEY `emprestimo_id` (`emprestimo_id`) USING BTREE,
  ADD KEY `tb_ferramentas_emprestimo_ibfk_2` (`ferramenta_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_amigos`
--
ALTER TABLE `tb_amigos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tb_fabricantes`
--
ALTER TABLE `tb_fabricantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  MODIFY `id` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tb_emprestimos`
--
ALTER TABLE `tb_emprestimos`
  ADD CONSTRAINT `tb_emprestimos_ibfk_1` FOREIGN KEY (`amigo_id`) REFERENCES `tb_amigos` (`id`) ON DELETE CASCADE;

--
-- Restrições para tabelas `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  ADD CONSTRAINT `tb_ferramentas_ibfk_1` FOREIGN KEY (`fabricante_id`) REFERENCES `tb_fabricantes` (`id`) ON UPDATE NO ACTION;

--
-- Restrições para tabelas `tb_ferramentas_emprestimo`
--
ALTER TABLE `tb_ferramentas_emprestimo`
  ADD CONSTRAINT `tb_ferramentas_emprestimo_ibfk_1` FOREIGN KEY (`emprestimo_id`) REFERENCES `tb_emprestimos` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tb_ferramentas_emprestimo_ibfk_2` FOREIGN KEY (`ferramenta_id`) REFERENCES `tb_ferramentas` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
