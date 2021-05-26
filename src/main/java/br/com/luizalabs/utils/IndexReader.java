package br.com.luizalabs.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexReader {

    private IndexReader() {
        throw new IllegalStateException("Index reader class");
    }

    private static final Logger logger = Logger.getLogger(IndexReader.class.getName());
    private static final String IDX_NAME = "/remissiveIndex.dat";

    public static Map<String, List<String>> readBinary(final String path) throws IOException {
        Map<String, List<String>> index = new HashMap<>();
        ObjectInputStream objInput = null;
        FileInputStream fileInputStream = null;
        try {
            var file = new File(path.concat(IDX_NAME));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                objInput = new ObjectInputStream(fileInputStream);
                index = (Map<String, List<String>>) objInput.readObject();
            }
        } catch(IOException ioException) {
            logger.log(java.util.logging.Level.SEVERE, ioException, () -> "Erro ao ler arquivo " + IDX_NAME);
        } catch(ClassNotFoundException notFoundException) {
            logger.log(java.util.logging.Level.SEVERE, notFoundException, () -> "Erro ao tentar fazer cast do map");
        } finally {
            if (objInput != null) { objInput.close(); }
            if (fileInputStream != null) { fileInputStream.close(); }
        }

        return index;
    }

    public static void writeBinary(String path, Map<String, List<String>> index) throws IOException {
        ObjectOutputStream objOutput = null;
        FileOutputStream fileOutputStream = null;
        var dirPath = new File(path);
        if (!dirPath.exists()) dirPath.mkdirs();
        var file = new File(path.concat(IDX_NAME));
        try {
            cleanUp(file.toPath());
            createFile(file);
            fileOutputStream = new FileOutputStream(file);
            objOutput = new ObjectOutputStream(fileOutputStream);
            objOutput.writeObject(index);
        } catch(IOException exception) {
            logger.log(Level.SEVERE, exception, () -> "Erro ao tentar escrever o arquivo " + path);
        } finally {
            if (objOutput != null) { objOutput.close(); }
            if (fileOutputStream != null) { fileOutputStream.close(); }
        }
    }

    public static void cleanUp(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    public static void createFile(File file) throws IOException {
        if (!file.createNewFile()) {
            logger.log(Level.SEVERE, "Erro ao criar arquivo {0}", file.getName());
        }
    }

}
