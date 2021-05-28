package br.com.luizalabs.io;

import br.com.luizalabs.io.utils.Config;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class IndexService {

    private static IndexService instance;
    private static IndexPersistence indexPersistence;

    private IndexService() {
    }

    public static IndexService getInstance() {
        if (instance == null) {
            instance = new IndexService();
        }

        return instance;
    }

    private static IndexPersistence indexPersistence() {
        if (indexPersistence == null) {
            indexPersistence = new IndexPersistence();
        }

        return indexPersistence;
    }

    public Map<String, Set<String>> index() throws IOException, ClassNotFoundException {
        return indexPersistence().read(getPath());
    }
    public void save(Map<String, Set<String>> indexData) throws IOException {
        indexPersistence().write(getPath(), indexData);
    }

    public String getPath() {
        return Config.SEARCH_INDEX_PATH.get();
    }
}
