package com.iesam.digitallibrary.user.domain;

public interface UserRepository {
    void createUser(User user);
    void deleteUser(String id);
    void modifyUser(User user);
}
