package br.com.luizalabs.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOIndexUtil {

    private static final Logger logger = Logger.getLogger(IOIndexUtil.class.getName());
    private static final String IDX_PATH = System.getenv("SEARCH_INDEX_PATH");
    private static final String IDX_NAME = "remissiveIndex.dat";

    public static void writeBinary(Map<String, List<String>> remissiveIndex) {
        File dirPath = new File(IDX_PATH);
        if (!dirPath.exists()) dirPath.mkdirs();
        File file = new File(IDX_PATH.concat(IDX_NAME));
        try {
            cleanUp(file.toPath());
            createFile(file);
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(remissiveIndex);
            objOutput.close();
        } catch(IOException erro) {
            logger.log(Level.SEVERE, "Erro ao tentar escrever o arquivo "+IDX_PATH+" - "+erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, List<String>> readBinary() {
        Map<String, List<String>>  map = new HashMap<>();
        try {
            File file = new File(IDX_PATH.concat(IDX_NAME));
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                map = (Map<String, List<String>>) objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            logger.log(Level.SEVERE, "Erro ao ler arquivo", erro1.getMessage());

        } catch(ClassNotFoundException erro2) {
            logger.log(Level.SEVERE, "Erro ao escrever arquivo", erro2.getMessage());
        }

        return map;
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
