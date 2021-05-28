package br.com.luizalabs.io.utils;

import java.io.*;
import java.util.Map;

public class SerializeUtils {

    public static byte[] serialize(Map value) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(value);
        }

        return out.toByteArray();
    }

    public static <T extends Map> T deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try(ByteArrayInputStream bis = new ByteArrayInputStream(data)) {
            //noinspection unchecked
            return (T) new ObjectInputStream(bis).readObject();
        }
    }
}
