package ru.avkalabin.model;

public class User {

    private final String username;
    private final String password;
    private final String id;
    private final String relativeId;

    public User(String id, String username, String password, String relativeId) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.relativeId = relativeId;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getRelativeId() {
        return relativeId;
    }

    public boolean isSameUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
