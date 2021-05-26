package br.com.luizalabs.index;

import br.com.luizalabs.index.preprocess.Processor;
import br.com.luizalabs.utils.IndexHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessHandler {

    private static final Map<String, List<String>> indexData = new HashMap<>();

    public static void run(Processor processor) {
        indexData.putAll(processor.sumarize());
    }

    public static void run(List<Processor> processors) {
        processors.forEach(processor -> run(processor));
    }

    public static final Map<String, List<String>> indexData() {
        return indexData;
    }

}
