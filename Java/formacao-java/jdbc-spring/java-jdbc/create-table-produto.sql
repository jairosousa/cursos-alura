CREATE TABLE `loja_virtual`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO produto(nome, descricao) VALUES ('Notebook Dell', 'G3');
INSERT INTO produto(nome, descricao) VALUES ('Smart TV', '43');
INSERT INTO produto(nome, descricao) VALUES ('Geladeira', 'Duplex 430l');
  
  