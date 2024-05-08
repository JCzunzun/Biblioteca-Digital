package com.iesam.digitallibrary.user.domain;

import java.util.ArrayList;

public class GetsUsersUseCase {
    private final UserRepository userRepository;

    public GetsUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> obtenerlistado() {
        return userRepository.getUsers();
    }
}
