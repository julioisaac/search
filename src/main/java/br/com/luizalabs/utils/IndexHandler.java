package br.com.luizalabs.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class IndexHandler {

    private static final Logger logger = Logger.getLogger(IndexHandler.class.getName());

    public static Map<String, List<String>> index(final String path) {
        try {
            return IndexReader.readBinary(path);
        } catch (IOException ioException) {
            logger.log(java.util.logging.Level.SEVERE, ioException, () -> "Erro ao tentar fechar ObjectInputStream "+path);
        }
        return new HashMap<>();
    }
    public static void save(String path, Map<String, List<String>> indexData) {
        try {
            IndexReader.writeBinary(path, indexData);
        } catch (IOException ioException) {
            logger.log(java.util.logging.Level.SEVERE, ioException, () -> "Erro ao tentar fechar ObjectOutputStream "+path);
        }
    }
}
