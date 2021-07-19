package com.searchengine.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FileRepository {
    Map<String, Set<String>> mapOfFiles;

    public FileRepository() {
        this.mapOfFiles = new HashMap<>();
    }

    public void addMapOfFile(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        while (line != null) {

            if (!line.trim().equals("")) {
                String[] words = line.split("[, \"'@_.?!/]+");

                for (String word : words) {

                    if (mapOfFiles.containsKey(word.toLowerCase())) {
                        Set<String> files = mapOfFiles.get(word.toLowerCase());
                        files.add(file.getName());
                    } else {
                        Set<String> files = new HashSet<>();
                        files.add(file.getName());
                        mapOfFiles.put(word.toLowerCase(), files);
                    }

                }
            }
            line = reader.readLine();
        }
    }

    public Map<String, Set<String>> getMapOfFiles() {
        return mapOfFiles;
    }

    public Set<String> searchWord(String word) {
        return mapOfFiles.get(word);
    }

}
