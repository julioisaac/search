package br.com.luizalabs.index.loader;

import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.loader.common.Loader;
import br.com.luizalabs.utils.Config;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLoader implements Loader {

    private static final Logger logger = Logger.getLogger(FileLoader.class.getName());

    @Override
    public List<String> getKeys() {
        return Arrays.asList(Config.ORIGIN_DATA_PATH.get().split(":"));
    }

    @Override
    public List<IndexData> load(List<String> keys) {
        List<IndexData> indexDataList = new ArrayList<>();
        try {
            List<File> files = new ArrayList<>();
            for (String path : keys) {
                files.addAll(Arrays.asList(Objects.requireNonNull(new File(path).listFiles(new FileLoaderFilter()))));
            }
            Collections.sort(files);
            for (File file : files) {
                indexDataList.add(new IndexData(file.getName(), Files.readAllLines(file.toPath()).toString()));
            }
        }
        catch (Exception ex) {
            logger.log(Level.WARNING, "Caminho dos arquivos não encontrado", ex);
            System.exit(1);
        }
        return indexDataList;
    }

}
