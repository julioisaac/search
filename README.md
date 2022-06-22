```
     _______. _______     ___      .______        ______  __    __  
    /       ||   ____|   /   \     |   _  \      /      ||  |  |  | 
   |   (----`|  |__     /  ^  \    |  |_)  |    |  ,----'|  |__|  | 
    \   \    |   __|   /  /_\  \   |      /     |  |     |   __   | 
.----)   |   |  |____ /  _____  \  |  |\  \----.|  `----.|  |  |  | 
|_______/    |_______/__/     \__\ | _| `._____| \______||__|  |__| 
                                                                   
```
[![CircleCI](https://circleci.com/gh/julioisaac/search.svg?style=svg&circle-token=70c2b456bc1ac593c5525fea8730892c64053b47)](https://app.circleci.com/pipelines/github/julioisaac/search)

Experimental Java Library for text summarization and search terms.
The program searches for a sentence in all [these](https://github.com/julioisaac/archives/raw/main/movies.zip)
files and displays how many and which files have a keyword. the ordination
of files is presented in ascending alphabetical order.

# Approach
The data optimization strategy for searching was to create an [index (inverted index or reverse index)](https://en.wikipedia.org/wiki/Inverted_index). This provided for more accurate and faster searches.
In this application, the index is being built based on a list of text files (.txt) which in turn is processed and inverted, becoming a list of words (terms) that refer to the files.

### Example:

**File data**

| **Name**          | **Content**      |
| :------------- | -------------: |
| don-de-dios.txt           | don de dios 2005 robin                                                              |
| hospital-de-urgencia.txt  | hospital de urgencia 1956 claude godard armando moreno tony leblanc                 |
| the-real-robin-hood.txt   | the real robin hood 2010 ridley scott russell crowe cate blanchett m. david melvin  |

**The remissive index would have this data**

| **Word**       | **Files containing occurrences**            |
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

## Prerequisites (run on Docker)

Before you start using it, you will need to have the following tools installed on your machine:
[Git](https://git-scm.com), [Docker](https://www.docker.com/).


## Install

```bash
# Clone this repository
$ git clone <https://github.com/julioisaac/search.git>

# Access the project folder
$ cd search

# Run the script to build the docker image
# (download the dependencies, run the tests, index the content and build the docker image)
$ ./scripts/build.sh

```

## Search test

```bash
# Run the shell script passing some term to search for.
$ ./scripts/search.sh "walt disney"
```

# Developer

## Prerequisites (run localhost)

To develop or evolve this project, you will need to have the following tools installed on your machine: [Java 11](https://www.java.com/),
[Git](https://git-scm.com) and [Maven](https://maven.apache.org/).

## Tests

Assuming the project has already been cloned, you can run the tests with the script below.

```bash
# Run the tests.
$ ./scripts/tests.sh

```
## Settings

To run the application localhost, you will need to configure the following environment variables.
The ORIGIN_DATA_PATH variable is used to define the path of the folder where the text files to be summarized are located.
The SEARCH_INDEX_PATH variable is used to define the path of the folder where the index will be saved.
```bash
$ export ORIGIN_DATA_PATH=${SEU_PATH_DADOS}
$ export SEARCH_INDEX_PATH=${SEU_PATH_INDEX}
```

## Packing

The maven command will create in the target folder the jar's _search-indexer.jar_ and _search-application.jar_ respectively used to index the data and search for terms.
```bash
# Building the packages
$ mvn clean package

```

## Indexing data

When running the application below, the files will be processed and the index will be generated.
```bash
# Indexing the files
$ java -jar target/search-indexer.jar

```

## Testing a term

When running the application below, passing a sentence, the search returns how many and which files have the terms.
```bash
# Searching terms
$ java -jar target/search-application.jar "walt disney"

```

## Implementation

### Loader Interface

The current version implements the ```FileLoader``` class responsible for loading text files from disk.

If it is necessary to change the origin of the data to be indexed, the ```Loader``` interface must be implemented
See example below:
```java
// Example
public class BDLoader implements Loader {
...
```
The ```BDLoader``` object would in turn be loaded by the Loaderfactory
```java
// Example
...
List<IndexData> indexDataList = new LoaderFactory()
      .add(new BDLoader())
      .load();
...
```

### WordTransformer Interface

The current version implements the ```SanitizeWordTransformer``` and ```StopWordTransformer``` classes. Implementations apply some kind of treatment to the word before it is indexed.

If you need to do other types of word treatment, you must implement the ```Transformer``` interface
See example below:
```java
// Example
public class LemmatizeTransformer implements WordTransformer {
...
```
The ```LemmatizeTransformer``` object would in turn be added to the ```IndexBuilder``` responsible for creating the index
```java
// Example
...
Map<String, Set<String>> idx = new IndexBuilder.Builder()
      .addTransformer(new LemmatizeTransformer())
      .summarize(indexDataList)
      .build();
...
```

## About

Experimental project of indexing and textual search. There is no framework used, only pure Java.


