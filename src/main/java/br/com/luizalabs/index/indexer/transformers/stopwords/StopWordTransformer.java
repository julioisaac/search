package br.com.luizalabs.index.indexer.transformers.stopwords;

import br.com.luizalabs.index.indexer.transformers.WordTransformer;

public class StopWordTransformer implements WordTransformer {
    @Override
    public String process(String word) {
        return null;
    }

    @Override
    public boolean enable(String word) {
        return word == null || word.isEmpty() || StopWords.getInstance().isStopWord(word);
    }
}
