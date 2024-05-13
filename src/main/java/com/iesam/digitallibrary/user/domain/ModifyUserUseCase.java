package com.iesam.digitallibrary.user.domain;

public class ModifyUserUseCase {
    public final UserRepository userRepository;

    public ModifyUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        userRepository.modifyUser(user);
    }
}
