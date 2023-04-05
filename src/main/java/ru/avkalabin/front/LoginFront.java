package ru.avkalabin.front;

import ru.avkalabin.model.User;
import ru.avkalabin.repository.UserRepository;
import ru.avkalabin.session.UserSession;

import javax.swing.*;
import java.util.NoSuchElementException;

public class LoginFront implements FtBase {

    private final UserRepository userRepository;

    public LoginFront(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void start(UserSession userSession) throws Exception {

        String username = JOptionPane.showInputDialog("Username");
        String password = JOptionPane.showInputDialog("Password");
        User user;

        try {
            user = userRepository.findAll()
                    .stream()
                    .filter(u -> u.isSameUser(username, password))
                    .findFirst()
                    .orElseThrow();
            userSession.setUser(user);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "User not found :(", "Error", JOptionPane.ERROR_MESSAGE);
            start(userSession);
        }
    }
}