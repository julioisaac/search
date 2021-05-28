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

        Validation.sentence(args);
        Validation.index(index);
        String[] words = Validation.checkSameWords(args[0]);

        long startTime = System.nanoTime();

        var searcher = new FindService(index);
        List<String> results = searcher.findByTerms(words);

        var elapsedTime = (System.nanoTime() - startTime);
        var elapsedTimeInSecond = (double) elapsedTime / 1000_000_000;

        var terms = String.join(" ", words);
        var occurrences = String.join("\n", results);

        logger.log(Level.INFO, Msg.OUTPUT, new Object[]{results.size(), terms, terms, occurrences});
        logger.log(Level.INFO, "Time elapsed in search\n{0} nanoseconds\n{1} s", new Object[]{elapsedTime, elapsedTimeInSecond});
    }
}
