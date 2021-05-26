package br.com.luizalabs.index.indexer.common;

import br.com.luizalabs.index.indexer.common.WordTransformer;

import java.util.List;

public class TransformersFactory {

    public static String reword(List<WordTransformer> wordTransformers, String word) {
        for (WordTransformer wordTransformer : wordTransformers) {
            word = wordTransformer.transform(word);
        }
        return word;
    }

}
