package br.com.luizalabs.utils;

import java.util.List;
import java.util.Map;

public class IndexHandler {

    public static Map<String, List<String>> index(final String path) {
        return IndexReader.readBinary(path);
    }

    public static void save(String path, Map<String, List<String>> indexData) {
        IndexReader.writeBinary(path, indexData);
    }
}
