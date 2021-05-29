```
     _______. _______     ___      .______        ______  __    __  
    /       ||   ____|   /   \     |   _  \      /      ||  |  |  | 
   |   (----`|  |__     /  ^  \    |  |_)  |    |  ,----'|  |__|  | 
    \   \    |   __|   /  /_\  \   |      /     |  |     |   __   | 
.----)   |   |  |____ /  _____  \  |  |\  \----.|  `----.|  |  |  | 
|_______/    |_______/__/     \__\ | _| `._____| \______||__|  |__| 

Desafio @luizalabs                                                                    
```
[![CircleCI](https://circleci.com/gh/julioisaac/search.svg?style=svg&circle-token=70c2b456bc1ac593c5525fea8730892c64053b47)](https://app.circleci.com/pipelines/github/julioisaac/search)

Biblioteca Java para sumarização de texto e busca por termos.
O programa busca por uma sentença em todos [estes](https://github.com/julioisaac/archives/raw/main/movies.zip)
arquivos e exibe quantos e quais arquivos possuem a palavra-chave. A ordenação
dos arquivos é apresentada em ordem crescente e alfabética.

# Abordagem
A estratégia de otimização dos dados para busca foi criar um [índice remissivo (índice invertido ou índice reverso)](https://en.wikipedia.org/wiki/Inverted_index). Isso proveu a realização de buscas mais precisas e rápidas.
Nesta aplicação o índice remissivo está sendo construído com base em uma lista de arquivos de texto(.txt) que por sua vez é processada e invertida, passando a ser uma lista de palavras(termos) que referenciam os arquivos.

### Exemplo:

**Dados dos arquivos**

| **Nome**          | **Conteúdo**      |
| :------------- | -------------: |
| don-de-dios.txt           | don de dios 2005 robin                                                              |
| hospital-de-urgencia.txt  | hospital de urgencia 1956 claude godard armando moreno tony leblanc                 |
| the-real-robin-hood.txt   | the real robin hood 2010 ridley scott russell crowe cate blanchett m. david melvin  |

**O índice remissivo teria esses dados**

| **Palavra**       | **Ocorrências nos arquivos**            |
| :-------------| -------------:                              |
| cate          |   the-real-robin-hood.txt                   |
| leblanc       |   hospital-de-urgencia.txt                  |
| don           |   don-de-dios.txt                           |
| melvin        |   the-real-robin-hood.txt                   |
| crowe         |   the-real-robin-hood.txt                   |
| armando       |   hospital-de-urgencia.txt                  |
| dios          |   don-de-dios.txt                           |
| moreno        |   hospital-de-urgencia.txt                  |
| 2010          |   the-real-robin-hood.txt                   |
| real          |   the-real-robin-hood.txt                   |
| ridley        |   the-real-robin-hood.txt                   |
| hood          |   the-real-robin-hood.txt                   |
| blanchett     |   the-real-robin-hood.txt                   |
| tony          |   hospital-de-urgencia.txt                  |
| robin         |   the-real-robin-hood.txt, don-de-dios.txt  |
| claude        |   hospital-de-urgencia.txt                  |
| 2005          |   don-de-dios.txt                           |
| russell       |   the-real-robin-hood.txt                   |
| godard        |   hospital-de-urgencia.txt                  |
| david         |   the-real-robin-hood.txt                   |
| scott         |   the-real-robin-hood.txt                   |
| hospital      |   hospital-de-urgencia.txt                  |
| urgencia      |   hospital-de-urgencia.txt                  |
| 1956          |   hospital-de-urgencia.txt                  |

## Pré-requisitos (rodar no Docker)

Antes de começar a usar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Docker](https://www.docker.com/).

## Instalar

```bash
# Clone este repositório
$ git clone <https://github.com/julioisaac/search.git>

# Acesse a pasta do projeto
$ cd search

# Rode o script para construir a imagem docker
# (baixa as dependências, roda os testes, indexa o conteúdo e cria a imagem docker)
$ ./scripts/build.sh

```

## Teste busca

```bash
# Execute o shell script passando algum termo para buscar.
$ ./scripts/search.sh "walt disney"
```

# Desenvolvedor

## Pré-requisitos (rodar local)

Para desenvolver ou evoluir esse projeto, você vai precisar ter instalado em sua máquina as seguintes ferramentas: [Java 11](https://www.java.com/),
[Git](https://git-scm.com) e [Maven](https://maven.apache.org/).

## Testes

Assumindo que o projeto já tenha sido clonado, você pode rodar os testes com o script abaixo.

```bash
# Rode os testes.
$ ./scripts/tests.sh

```
## Configurações

Para rodar a aplicação localmente, você precisará configurar as seguintes variavéis de ambiente.
A variável ORIGIN_DATA_PATH serve para definir o caminho da pasta onde estão os arquivos texto que serão sumarizados.
A variável SEARCH_INDEX_PATH serve para definir o caminho da pasta onde o índice será salvo.
```bash
$ export ORIGIN_DATA_PATH=${SEU_PATH_DADOS}
$ export SEARCH_INDEX_PATH=${SEU_PATH_INDEX}
```

## Empacotando

O comando maven irá criar na pasta target os jar's  _search-indexer.jar_ e _search-application.jar_ respectivamente usados para indexar os dados e buscar os termos.
```bash
# Construindo os pacotes
$ mvn clean package

```

## Indexando dados

Ao rodar a aplicação abaixo, os arquivos serão processados e o índice remissivo será gerado.
```bash
# Indexando os arquivos
$ java -jar target/search-indexer.jar

```

## Testando um termo

Ao rodar a aplicação abaixo, passando alguma sentença, a busca retorna quantos e quais arquivos possuem os termos.
```bash
# Buscando termos
$ java -jar target/search-application.jar "walt disney"

```

## Implementação

### Interface Loader

A versão atual implementa a classe ```FileLoader``` responsável pelo carregamento dos arquivos texto do disco.

Caso necessário mudar a origem dos dados a serem indexados deve-se implementar a interface ```Loader```
Veja exemplo abaixo:
```java
// Exemplo
public class BDLoader implements Loader {
...
```
O objeto ```BDLoader``` por sua vez seria carregado pela Loaderfactory
```java
//Exemplo
...
List<IndexData> indexDataList = new LoaderFactory()
      .add(new BDLoader())
      .load();
...
```

### Interface WordTransformer

A versão atual implementa as classes ```SanitizeWordTransformer```  e ```StopWordTransformer```. As implementações aplicam algum tipo de tratamento à palavra antes de ser indexada.

Caso necessário fazer outros tipos de tratamento à palavra, deve-se implementar a interface ```Transformer```
Veja exemplo abaixo:
```java
// Exemplo
public class LemmatizeTransformer implements WordTransformer {
...
```
O objeto ```LemmatizeTransformer``` por sua vez seria adicionado ao ```IndexBuilder``` responsável pela criação do índice remissivo
```java
//Exemplo
...
Map<String, Set<String>> idx = new IndexBuilder.Builder()
      .addTransformer(new LemmatizeTransformer())
      .summarize(indexDataList)
      .build();
...
```

## Sobre

Desafio de busca proposto pelo time do luizalabs.


