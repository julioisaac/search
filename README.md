```
     _______. _______     ___      .______        ______  __    __  
    /       ||   ____|   /   \     |   _  \      /      ||  |  |  | 
   |   (----`|  |__     /  ^  \    |  |_)  |    |  ,----'|  |__|  | 
    \   \    |   __|   /  /_\  \   |      /     |  |     |   __   | 
.----)   |   |  |____ /  _____  \  |  |\  \----.|  `----.|  |  |  | 
|_______/    |_______/__/     \__\ | _| `._____| \______||__|  |__| 

Desafio @luizalabs                                                                    
```

Biblioteca Java para sumarização de texto e busca por termos.
O programa busca por uma sentença em todos [estes](https://github.com/julioisaac/archives/raw/main/movies.zip)
arquivos e exibe quantos e quais arquivos possuem a palavra chave. A ordenação
dos arquivos é apresentada em ordem crescente e alfabética.

## Implementação
A estratégia de otimização dos dados para busca foi de criar um [índice remissivo (índice invertido ou índice reverso)](https://en.wikipedia.org/wiki/Inverted_index). Isso proveu a realização de buscas mais precisas e rápidas.
Nesta aplicação o índice remissivo está sendo construído com base em uma lista de arquivos de texto(.txt) que por sua vez é processada e invertida passando a ser uma lista de palavras(termos) que referenciam  os arquivos.

Exemplo:
| **LISTA DE ARQUIVOS DE ENTRADA**        ||
| **Nome**          | **Conteúdo**      |
| :------------- | -------------: |
| don-de-dios.txt           | don de dios 2005 robin                                                              |
| hospital-de-urgencia.txt  | hospital de urgencia 1956 claude godard armando moreno tony leblanc                 |
| the-real-robin-hood.txt   | the real robin hood 2010 ridley scott russell crowe cate blanchett m. david melvin  |

| **ARQUIVO DE ÍNDICE CHAVE E VALOR**                        ||
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

## Pré-requisitos

Antes de começar a usar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Docker](https://www.docker.com/).

## Instalar

```bash
# Clone este repositório
$ git clone <https://github.com/julioisaac/search.git>

# Acesse a pasta do projeto
$ cd search

# Rode o script para instalar as dependencias, rodar os testes, empacotar as aplicações, gerar os indices e construir a imagem docker final.
$ ./scripts/build.sh

```

## Usar

### Busca

```bash
# Execute o shell script passando algum termo para buscar.
$ ./scripts/search.sh "walt disney"
```


## Sobre

Desafio de busca proposto pelo time do luizalabs


