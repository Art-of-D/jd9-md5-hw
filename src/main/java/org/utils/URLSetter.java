package org.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class URLSetter {
    private static final String FILENAME = "src/main/resources/sql/connection_url.json";
    private Map<String, Object> map = new HashMap<>();

    public URLSetter(){
        try {
            String string = Files.readAllLines(Paths.get(FILENAME).toAbsolutePath()).stream().collect(Collectors.joining("\n"));
            TypeToken<?> ttoken = TypeToken.getParameterized(Map.class, String.class, Object.class);
            map = new Gson().fromJson(string, ttoken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, Object> getMap() {
        return map;
    }
}
