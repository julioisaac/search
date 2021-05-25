# Search

Biblioteca Java para sumarização de arquivos texto e busca por termos.

### Sobre

Desafio proposto pelo time de busca do luizalabs

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java_11](https://www.java.com/), [Maven](https://maven.apache.org/).

### Instalando

```bash
# Clone este repositório
$ git clone <https://github.com/julioisaac/search.git>

# Acesse a pasta do projeto
$ cd search

# Rodando os testes
$ mvn test

# Construindo e empacotando as aplicações
$ mvn clean install

# Execute o shell script para indexar os arquivos
$ ./scripts/index.sh
```


### Usando

#### Sumarizando
```bash
# Execute o shell script para sumarizar os arquivos
$ ./scripts/index.sh
```

#### Buscando

```bash
# Execute o shell script passando algum termo para buscar.
$ ./scripts/search.sh "walt disney"
```


