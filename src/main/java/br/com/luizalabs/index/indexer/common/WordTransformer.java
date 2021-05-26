package br.com.luizalabs.index.indexer.common;

public interface WordTransformer {
    String process(String word);
    boolean enable(String word);

    default String transform(String word) {
        if (enable(word)) {
            return process(word);
        }
        return word;
    }
}
