package ru.avkalabin.session;

import ru.avkalabin.model.User;

public enum UserSession {
    INSTANCE;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
