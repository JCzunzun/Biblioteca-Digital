package com.iesam.digitallibrary.user.domain;

public class CreateUserUseCase {
    public final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.createUser(user);
    }
}
