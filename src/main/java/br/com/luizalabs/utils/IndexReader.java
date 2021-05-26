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

    private static final Logger logger = Logger.getLogger(IndexReader.class.getName());
    private static final String IDX_NAME = "/remissiveIndex.dat";

    public static Map<String, List<String>> readBinary(final String path) {
        Map<String, List<String>> index = new HashMap<>();
        try {
            File file = new File(path.concat(IDX_NAME));
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                index = (Map<String, List<String>>) objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            logger.log(Level.SEVERE, "Erro ao ler arquivo", erro1.getMessage());

        } catch(ClassNotFoundException erro2) {
            logger.log(Level.SEVERE, "Erro ao escrever arquivo", erro2.getMessage());
        }

        return index;
    }

    public static void writeBinary(String path, Map<String, List<String>> index) {
        File dirPath = new File(path);
        if (!dirPath.exists()) dirPath.mkdirs();
        File file = new File(path.concat(IDX_NAME));
        try {
            cleanUp(file.toPath());
            createFile(file);
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(index);
            objOutput.close();
        } catch(IOException erro) {
            logger.log(Level.SEVERE, "Erro ao tentar escrever o arquivo "+path+" - "+erro.getMessage());
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
