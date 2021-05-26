package br.com.luizalabs.index.indexer.common;

import br.com.luizalabs.index.domain.IndexData;

import java.util.*;

public class IndexBuilder {

    public static class Builder {
        private Map<String, List<String>> idx = new HashMap<>();
        private List<WordTransformer> transformers = new ArrayList<>();

        public Builder add(WordTransformer transformer) {
            transformers.add(transformer);
            return this;
        }

        public Builder summarize(List<IndexData> indexDataList) {
            Map<String, List<String>> idx = new HashMap<>();
            for (IndexData indexData : indexDataList) {
                build(idx, indexData);
            }
            this.idx = idx;
            return this;
        }

        private Map<String, List<String>> build(Map<String, List<String>> idx, IndexData indexData) {
            for (String word : indexData.tokens()) {
                word = TransformersFactory.reword(transformers, word);
                if (word == null) { continue; }
                List<String> values;
                if (idx.get(word) != null) {
                    values = idx.get(word);
                    if (!values.contains(indexData.getKey())) {
                        values.add(indexData.getKey());
                    }
                }
                else {
                    values = new ArrayList<>();
                    values.add(indexData.getKey());
                }
                idx.put(word.toLowerCase(), values);
            }
            return idx;
        }
        public Map<String, List<String>> build(){
            return this.idx;
        }
    }

}
