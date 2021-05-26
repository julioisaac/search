package br.com.luizalabs.index.preprocess;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Text implements Data {

    private static final Logger logger = Logger.getLogger(Text.class.getName());

    private final String[] paths;
    private File[] dataFiles;

    public Text(String[] paths) {
        this.paths = paths;
    }

    @Override
    public void read() {
        try {
            File[] files = Stream.of(paths).flatMap(path -> Stream.of(new File(path).listFiles())).toArray(File[]::new);
            Arrays.sort(Objects.requireNonNull(files));
            this.dataFiles = files;
        }
        catch (Exception ex) {
            logger.log(Level.WARNING, "Caminho dos arquivos não encontrado");
            System.exit(1);
        }
    }

    @Override
    public File[] get() {
        return this.dataFiles != null ? this.dataFiles : new File[0];
    }
}
