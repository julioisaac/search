package br.com.luizalabs.index;

import br.com.luizalabs.index.preprocess.Processor;
import br.com.luizalabs.utils.IOIndexUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleProcessors {

    private static final Map<String, List<String>> remissiveIndex = new HashMap<>();

    public static void run(Processor processor) {
        remissiveIndex.putAll(processor.sumarize());
    }

    public static void run(List<Processor> processors) {
        processors.forEach(processor -> run(processor));
    }

    public static void writeIdx() {
        IOIndexUtil.writeBinary(remissiveIndex);
    }

}
