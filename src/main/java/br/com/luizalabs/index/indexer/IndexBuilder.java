package br.com.luizalabs.index.indexer;

import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.indexer.transformers.TransformersFactory;
import br.com.luizalabs.index.indexer.transformers.WordTransformer;

import java.util.*;

public class IndexBuilder {

    private IndexBuilder() {
    }

    public static class Builder {
        private Map<String, Set<String>> idx = new HashMap<>();
        private final List<WordTransformer> transformers = new ArrayList<>();

        public Builder addTransformer(WordTransformer transformer) {
            transformers.add(transformer);
            return this;
        }

        public Builder summarize(List<IndexData> indexDataList) {
            Map<String, Set<String>> index = new HashMap<>();
            for (IndexData indexData : indexDataList) {
                build(index, indexData);
            }
            this.idx = index;
            return this;
        }

        private void build(Map<String, Set<String>> idx, IndexData indexData) {
            for (String word : indexData.tokens()) {
                word = TransformersFactory.reword(transformers, word);
                if (word == null) { continue; }
                idx.computeIfAbsent(word.toLowerCase(), k -> new HashSet<>()).add(indexData.getKey());
            }
        }
        public Map<String, Set<String>> build(){
            return this.idx;
        }
    }

}
