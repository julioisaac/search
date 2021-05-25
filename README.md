# Search

Biblioteca Java para sumarização de arquivos texto e busca por termos.

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java_11](https://www.java.com/), [Maven](https://maven.apache.org/).

## Dados

Massa de dados usada nos testes de indexação e busca. 
Baixe em <https://github.com/julioisaac/archives/blob/main/movies.zip>

## Instalando

```bash
# Clone este repositório
$ git clone <https://github.com/julioisaac/search.git>

# Acesse a pasta do projeto
$ cd search

# Rode os testes
$ mvn test

# Construa e empacote as aplicações
$ mvn clean install
```
## Configurando

No arquivo ```scripts/setenv.sh```, configure as variáveis de ambiente ```ORIGIN_DATA_PATH``` com o caminho dos arquivos a serem processados e ```SEARCH_INDEX_PATH``` com o caminho onde será salvo o índice resmissivo.

```shell
# Exemplo
export ORIGIN_DATA_PATH=/Users/julioisaac/data
export SEARCH_INDEX_PATH=/var/lib/search/data
```

## Usando

### Sumarizando

Depois de definir origem dos dados e destino do índice, rodamos o script de indexação

```bash
# Execute o shell script para sumarizar os arquivos
$ ./scripts/index.sh
```

### Buscando

```bash
# Execute o shell script passando algum termo para buscar.
$ ./scripts/search.sh "walt disney"
```

## Sobre

Desafio de busca proposto pelo time do luizalabs


