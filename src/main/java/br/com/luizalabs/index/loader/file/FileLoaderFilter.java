package br.com.luizalabs.index.loader.file;

import java.io.File;
import java.io.FilenameFilter;

public class FileLoaderFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt");
    }
}
