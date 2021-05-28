package br.com.luizalabs.index.indexer.transformers;

import java.util.List;

public class TransformersFactory {

    private TransformersFactory() {
    }

    public static String reword(List<WordTransformer> wordTransformers, String word) {
        for (WordTransformer wordTransformer : wordTransformers) {
            word = wordTransformer.transform(word);
        }
        return word;
    }

}
