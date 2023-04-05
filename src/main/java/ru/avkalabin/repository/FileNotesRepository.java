package ru.avkalabin.repository;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileNotesRepository implements NotesRepository {
    private final Path pathToFile;

    public FileNotesRepository(Path pathToFile) {
        this.pathToFile = pathToFile;
    }


    @Override
    public void saveNote(String note, String username, String id) throws Exception {
        Files.write(pathToFile, (username + "," + note + "," + id + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public List<String> getNotesContent(String username, String relativeId) throws Exception {
        List<String[]> notes;
        try (InputStream is = Files.newInputStream(pathToFile);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            notes = reader.readAll();
        }
        return notes.stream()
                .filter(array -> array[0].equals(username) || array[2].equals(relativeId))
                .map(array -> array[1])
                .toList();
    }
}
