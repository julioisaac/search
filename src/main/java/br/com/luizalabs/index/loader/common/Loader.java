package br.com.luizalabs.index.loader.common;

import br.com.luizalabs.index.domain.IndexData;

import java.util.List;

public interface Loader {

    List<String> getKeys();

    List<IndexData> load(List<String> keys);

    default List<IndexData> load() {
        return load(getKeys());
    }

}
