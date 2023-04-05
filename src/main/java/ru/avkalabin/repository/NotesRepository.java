package ru.avkalabin.repository;

import java.util.List;

public interface NotesRepository {

    void saveNote(String note, String username,String id) throws Exception;

    List<String> getNotesContent(String username, String relativeId) throws Exception;
}


