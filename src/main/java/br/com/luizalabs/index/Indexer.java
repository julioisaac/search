package br.com.luizalabs.index;

import br.com.luizalabs.index.preprocess.TxtProcessor;
import br.com.luizalabs.index.preprocess.Text;
import br.com.luizalabs.index.preprocess.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Indexer {

    private static final Logger logger = Logger.getLogger(Indexer.class.getName());

    public static void main(String[] args) {

        String paths[] = System.getenv("ORIGIN_DATA_PATH").split(":");
        if (paths.length != 1) {
            logger.log(Level.WARNING, "Path dos arquivos requerido");
            System.exit(1);
        }

        Text texts = new Text(paths);
        List<Processor> processors = new ArrayList<>();
        processors.add(new TxtProcessor(texts));

        HandleProcessors.run(processors);
        HandleProcessors.writeIdx();
    }

}