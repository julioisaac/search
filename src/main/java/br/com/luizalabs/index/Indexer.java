package br.com.luizalabs.index;

import br.com.luizalabs.index.preprocess.TxtProcessor;
import br.com.luizalabs.index.preprocess.Text;
import br.com.luizalabs.index.preprocess.Processor;
import br.com.luizalabs.utils.IndexHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Indexer {

    private static final Logger logger = Logger.getLogger(Indexer.class.getName());

    public static void main(String[] args) {

        String[] paths = System.getenv("ORIGIN_DATA_PATH").split(":");
        String indexPath = System.getenv("SEARCH_INDEX_PATH");
        if (paths.length != 1) {
            logger.log(Level.WARNING, "Path dos arquivos requerido");
            System.exit(1);
        }

        logger.log(Level.INFO, "Iniciando processadores de dados");
        var txts = new Text(paths);
        List<Processor> processors = new ArrayList<>();
        processors.add(new TxtProcessor(txts));

        logger.log(Level.INFO, "Processando texto e criando índices em memória");
        ProcessHandler.run(processors);
        logger.log(Level.INFO, "Gravando índices no disco");
        IndexHandler.save(indexPath, ProcessHandler.indexData());
        logger.log(Level.INFO, "DONE!");
    }

}
