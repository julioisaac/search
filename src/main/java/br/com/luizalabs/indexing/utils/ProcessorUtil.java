package br.com.luizalabs.indexing.utils;

public class ProcessorUtil {

    private ProcessorUtil() {
        throw new IllegalStateException("Processor utility class");
    }

    public static String[] splitBySpace(String text) {
        return text.split(" ");
    }

    public static String sanitize(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }

}
