CREATE TABLE unidade_federativa ( 
   id BIGINT NOT NULL AUTO_INCREMENT, 
   nome_estado VARCHAR(50) NOT NULL, 
   uf VARCHAR(2) NOT NULL, 
   data_cadastro DATETIME DEFAULT NULL 
);

INSERT INTO unidade_federativa(nome_estado, uf, data_cadastro) values('Santa Catarina', 'SC', PARSEDATETIME('2019-11-10 00:00:00', 'yyyy-MM-dd hh:mm:ss'));