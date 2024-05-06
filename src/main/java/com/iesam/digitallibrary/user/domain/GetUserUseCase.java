package com.iesam.digitallibrary.user.domain;

public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User execute(String id){
        return userRepository.getUser(id);
    }
}
