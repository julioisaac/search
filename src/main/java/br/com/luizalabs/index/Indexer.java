package br.com.luizalabs.index;

import br.com.luizalabs.index.indexer.common.IndexBuilder;
import br.com.luizalabs.index.indexer.SanitizeWordTransformer;
import br.com.luizalabs.index.indexer.StopWordTransformer;
import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.loader.FileLoader;
import br.com.luizalabs.index.loader.common.LoaderFactory;
import br.com.luizalabs.utils.IndexHandler;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Indexer {

    private static final Logger logger = Logger.getLogger(Indexer.class.getName());

    public static void main(String[] args) {

        logger.info("Iniciando indexação dos dados");
        List<IndexData> indexDataList = new LoaderFactory()
                .add(new FileLoader())
                .load();

        Map<String, List<String>> idx = new IndexBuilder.Builder()
                .add(new SanitizeWordTransformer())
                .add(new StopWordTransformer())
                .summarize(indexDataList)
                .build();

        logger.info("Gravando índices no disco");
        IndexHandler.save(idx);
        logger.info("DONE!");
    }

}
