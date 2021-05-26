package br.com.luizalabs.search;

import br.com.luizalabs.utils.IndexHandler;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());
    private static final Map<String, List<String>> index = IndexHandler.index(System.getenv("SEARCH_INDEX_PATH"));

    private static final String MSG_OCORRENCES = "Foram encontradas {0} ocorrências pelo termo \"{1}\" \nOs arquivos que possuem \"{2}\" são: \n\n{3}\n";

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        if (args.length != 1) {
            logger.log(Level.WARNING, "Buscar uma sentença");
            System.exit(1);
        }

        String sentence = args[0];
        var searcher = new Searcher(index);
        List<String> results = searcher.findByTerms(sentence);

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        logger.log(Level.INFO, MSG_OCORRENCES, new Object[]{results.size(), sentence, sentence, String.join("\n", results)});
        double elapsedTimeInSecond = (double) elapsedTime / 1000_000_000;
        logger.log(Level.INFO, "{0} nano", elapsedTime);
        logger.log(Level.INFO, "{0} s", elapsedTimeInSecond);
    }
}
