# Localidades IBGE :heavy_check_mark:

Esta é uma aplicação backend que consulta API públicas de localidades do IBGE e criar arquivos no formato JSON e CSV para download.

## Features

- Test

## Linguagens e libs utilizadas :books:

- Java EE
- Feign
- Thorntail

A aplicação foi desenvolvida usando os componentes da especificação Java EE 7 tais como CDI, JAX-RS entre outros. Ela é executada em um servidor 100% compatível com a especificação Java EE 7 o Thorntail que um servidor voltado para micro serviços pois possibilita subir somente os componentes necessários para  aplicação rodar e não toda lista de componentes da especificação. Toda a cobertura de teste foi feita usando JUnit com testes unitários.

## Como rodar a aplicação com Thorntail: :arrow_forward:

### Pré-requisitos
- Java JDK 8
- Apache Maven 3.5.4

### Rodando
Executar o arquivos run.sh apos o start do servidor a aplicação fica disponível em http://localhost:10000/rest-application

## O que a aplicação é capaz de fazer :checkered_flag:

#### Retorna o arquivo CSV com todos municípios do Brasil
  - http://localhost:10000/rest-application/api/ibge/municipios/csv [GET]
#### Retorna o arquivo JSON com todos municípios do Brasil
  - http://localhost:10000/rest-application/api/ibge/municipios/json [GET]
#### Recebe o ID do município e retorna seu nome
  - http://localhost:10000/rest-application/api/ibge/municipios/{id} [GET]
  - Caso o id foi consultado mais de uma vez ele busca de um cache e não da API pública
    
