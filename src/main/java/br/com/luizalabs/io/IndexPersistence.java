package br.com.luizalabs.io;

import br.com.luizalabs.io.utils.SerializeUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexPersistence {

    private static final Logger logger = Logger.getLogger(IndexPersistence.class.getName());
    private static final String IDX_NAME = "/remissiveIndex.dat";

    @SuppressWarnings("unchecked")
    public Map<String, Set<String>> read(String strPath) throws IOException, ClassNotFoundException {
        Path path = validation(strPath);
        return SerializeUtils.deserialize(Files.readAllBytes(path));
    }

    public void write(String strPath, Map<String, Set<String>> index) throws IOException {
        validation(index);
        String filePath = strPath.concat(IDX_NAME);
        Path path = new File(filePath).toPath();
        Files.deleteIfExists(path);
        Files.createFile(path);
        Files.write(path, SerializeUtils.serialize(index));
    }

    public void validation(Map<String, Set<String>> index) throws IOException {
        if (index == null) {
            logger.log(Level.SEVERE, "Index should not be null");
            throw new NullPointerException("Index file not be null");
        }
    }

    public Path validation(String path) throws IOException {
        String filePath = path.concat(IDX_NAME);
        File file = new File(filePath);
        if (!file.exists()) {
            logger.log(Level.SEVERE, "Index file not found path " + IDX_NAME);
            throw new FileNotFoundException("Index file not found path " + IDX_NAME);
        }
        return file.toPath();
    }

}
