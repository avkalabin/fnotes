package ru.avkalabin.front;

import ru.avkalabin.repository.NotesRepository;
import ru.avkalabin.session.UserSession;

import javax.swing.*;
import java.util.List;

public class NotesFront implements FtBase {

    private final NotesRepository notesRepository;

    public NotesFront(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public void start(UserSession userSession) throws Exception {
        List<String> notesContent = notesRepository.getNotesContent(userSession.getUser().getUsername(), userSession.getUser().getRelativeId());

        JOptionPane.showMessageDialog(null, notesContent.toString(), "Old notes: ", JOptionPane.INFORMATION_MESSAGE);


        String note = JOptionPane.showInputDialog("Your note:");
        notesRepository.saveNote(note, userSession.getUser().getUsername(), userSession.getUser().getId());
    }
}
