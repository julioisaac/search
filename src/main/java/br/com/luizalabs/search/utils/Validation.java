package br.com.luizalabs.search.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public final class Validation {

    private Validation(){}

    private static final Logger logger = Logger.getLogger(Validation.class.getName());

    public static void sentence(String[] args) {
        if (args.length != 1 || args[0].isEmpty()) {
            logger.severe("Enter the search parameter");
            throw new NullPointerException("Enter the search parameter");
        }
    }

    public static String[] checkSameWords(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        return Arrays.stream(words).distinct().toArray(String[]::new);
    }

    public static void index(Map<String, Set<String>> index) {
        if (index == null || index.size() == 0) {
            logger.severe("The index wasn't load");
            throw new NullPointerException("The index wasn't load");
        }
    }
}
