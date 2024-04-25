package com.iesam.digitallibrary.user.domain;

public class DeleteUserUserCase {
    public final UserRepository userRepository;
    public DeleteUserUserCase (UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public void delete(String id){
        userRepository.deleteUser(id);
    }
}
