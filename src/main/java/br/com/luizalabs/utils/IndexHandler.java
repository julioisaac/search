package br.com.luizalabs.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class IndexHandler {

    private static final Logger logger = Logger.getLogger(IndexHandler.class.getName());

    private IndexHandler() {
        throw new IllegalStateException("Index Handler class");
    }

    public static Map<String, List<String>> index() {
        try {
            return IndexReader.readBinary();
        } catch (IOException ioException) {
            logger.log(java.util.logging.Level.SEVERE, ioException, () -> "Erro ao tentar fechar ObjectInputStream "+Config.SEARCH_INDEX_PATH.get());
        }
        return new HashMap<>();
    }
    public static void save(Map<String, List<String>> indexData) {
        try {
            IndexReader.writeBinary(indexData);
        } catch (IOException ioException) {
            logger.log(java.util.logging.Level.SEVERE, ioException, () -> "Erro ao tentar fechar ObjectOutputStream "+Config.SEARCH_INDEX_PATH.get());
        }
    }
}
