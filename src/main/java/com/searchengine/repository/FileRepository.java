package com.searchengine.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FileRepository {

    Map<String, String> mapOfFiles;

    public FileRepository() {
        this.mapOfFiles = new HashMap<>();
    }

    public void addMapOfFile(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        while (line != null) {

            if (!line.trim().equals("")) {
                String[] words = line.split("[, '@_.?!]+");

                for (String word : words) {
                    if (mapOfFiles.containsKey(word) &&
                            !mapOfFiles.get(word).equals(file.getName())) {
                        mapOfFiles.put(word, mapOfFiles.get(word) + file.getName());
                    }

                    mapOfFiles.put(word, file.getName());
                }
            }
            line = reader.readLine();
        }
    }

    public Map<String, String> getMapOfFiles() {
        return mapOfFiles;
    }

}
