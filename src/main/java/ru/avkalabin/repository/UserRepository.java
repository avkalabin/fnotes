package ru.avkalabin.repository;

import ru.avkalabin.model.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {

    List<User> findAll() throws Exception;
}
