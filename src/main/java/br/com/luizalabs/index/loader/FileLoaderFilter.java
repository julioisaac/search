package br.com.luizalabs.index.loader;

import java.io.File;
import java.io.FilenameFilter;

public class FileLoaderFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        if (name.toLowerCase().endsWith(".txt")) return true;
        return false;
    }
}
