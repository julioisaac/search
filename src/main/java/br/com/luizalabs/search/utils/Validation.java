package br.com.luizalabs.search.utils;

import br.com.luizalabs.search.Searcher;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public final class Validation {

    private static final Logger logger = Logger.getLogger(Searcher.class.getName());

    public static void sentence(String[] args) {
        if (args.length != 1) {
            logger.severe("Enter the search parameter");
            throw new NullPointerException("Enter the search parameter");
        }
    }

    public static void index(Map<String, Set<String>> index) {
        if (index == null || index.size() == 0) {
            logger.severe("The index wasn't load");
            throw new NullPointerException("The index wasn't load");
        }
    }
}
