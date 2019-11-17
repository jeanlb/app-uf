# app-uf

## Aplicação para cadastro de unidades federativas do Brasil

Esta aplicação é uma API para as funcionalidades de cadastrar e listar as unidades federativas

### Comando para rodar em modo de desenvolvimento (usar profile dev)
java -jar -Dspring.profiles.active=dev target/app-uf-0.0.1-SNAPSHOT.jar

### Comando para rodar em modo de producao (usar profile prod)
nohup java -jar -Dspring.profiles.active=prod app-uf-0.0.1-SNAPSHOT.jar > output.log

### Comando para visualizar o log em producao
tail -f output.log
