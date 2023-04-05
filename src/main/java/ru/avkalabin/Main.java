package ru.avkalabin;

import ru.avkalabin.front.Front;
import ru.avkalabin.front.LoginFront;
import ru.avkalabin.front.NotesFront;
import ru.avkalabin.repository.FileNotesRepository;
import ru.avkalabin.repository.FileUserRepository;
import ru.avkalabin.session.UserSession;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        new Front(
                new LoginFront(
                        new FileUserRepository(Path.of("users.csv"))
                ),
                new NotesFront(
                        new FileNotesRepository(Path.of("notes.csv"))
                )).start(UserSession.INSTANCE);

    }
}