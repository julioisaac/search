package br.com.luizalabs.io.utils;

import java.io.*;
import java.util.Map;

public class SerializeUtils {

    private SerializeUtils() {}

    public static byte[] serialize(Map<String, ? extends Object> value) throws IOException {
        var out = new ByteArrayOutputStream();
        try(var outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(value);
        }

        return out.toByteArray();
    }

    public static <T extends Map> T deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try(var bis = new ByteArrayInputStream(data)) {
            //noinspection unchecked
            return (T) new ObjectInputStream(bis).readObject();
        }
    }
}
