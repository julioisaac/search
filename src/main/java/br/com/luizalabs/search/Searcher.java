package br.com.luizalabs.search;

import br.com.luizalabs.search.service.FindService;
import br.com.luizalabs.search.utils.Msg;
import br.com.luizalabs.search.utils.Validation;
import br.com.luizalabs.io.IndexService;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Searcher {

    private static final Logger logger = Logger.getLogger(Searcher.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Map<String, Set<String>> index = IndexService.getInstance().index();

        long startTime = System.nanoTime();

        Validation.sentence(args);
        String sentence = args[0];
        Validation.index(index);
        var searcher = new FindService(index);
        List<String> results = searcher.findByTerms(sentence);
        Collections.sort(results);

        long elapsedTime = (System.nanoTime() - startTime);
        double elapsedTimeInSecond = (double) elapsedTime / 1000_000_000;

        logger.log(Level.INFO, Msg.OUTPUT, new Object[]{results.size(), sentence, sentence, String.join("\n", results)});
        logger.log(Level.INFO, "{0} nanoseconds", elapsedTime);
        logger.log(Level.INFO, "{0} s", elapsedTimeInSecond);
    }
}
