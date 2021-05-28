package br.com.luizalabs.index.loader;

import br.com.luizalabs.index.domain.IndexData;

import java.util.List;

public interface Loader {

    List<String> getPaths();

    List<IndexData> load(List<String> keys);

    default List<IndexData> load() {
        return load(getPaths());
    }

}
