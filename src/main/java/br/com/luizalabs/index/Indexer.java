package br.com.luizalabs.index;

import br.com.luizalabs.index.indexer.IndexBuilder;
import br.com.luizalabs.index.indexer.transformers.sanitize.SanitizeWordTransformer;
import br.com.luizalabs.index.indexer.transformers.stopwords.StopWordTransformer;
import br.com.luizalabs.index.domain.IndexData;
import br.com.luizalabs.index.loader.file.FileLoader;
import br.com.luizalabs.index.loader.LoaderFactory;
import br.com.luizalabs.io.IndexService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class Indexer {

    private static final Logger logger = Logger.getLogger(Indexer.class.getName());

    public static void main(String[] args) throws IOException {

        logger.info("Loading files");
        List<IndexData> indexDataList = new LoaderFactory()
                .add(new FileLoader())
                .load();

        logger.info("Applying transformers and summarizing the data");
        Map<String, Set<String>> idx = new IndexBuilder.Builder()
                .addTransformer(new SanitizeWordTransformer())
                .addTransformer(new StopWordTransformer())
                .summarize(indexDataList)
                .build();

        logger.info("Saving the remissive index");
        IndexService.getInstance().save(idx);
        logger.info("DONE!");
    }

}
