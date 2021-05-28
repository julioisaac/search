package br.com.luizalabs.index.loader;

import br.com.luizalabs.index.domain.IndexData;

import java.util.ArrayList;
import java.util.List;

public class LoaderFactory {

    private List<Loader> loaders = new ArrayList<>();

    public LoaderFactory add(Loader loader) {
        loaders.add(loader);
        return this;
    }

    public List<IndexData> load() {
        List<IndexData> indexData = new ArrayList<>();
        loaders.forEach(loader -> indexData.addAll(loader.load()));
        return indexData;
    }

}
