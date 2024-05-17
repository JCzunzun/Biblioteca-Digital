package com.iesam.digitallibrary.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    CreateUserUseCase createUserUseCase;
    @BeforeEach
    public void setUp(){
        createUserUseCase= new CreateUserUseCase(userRepository);
    }
    @AfterEach
    public void clear(){
        createUserUseCase=null;
    }
    @Test
    public void reciboUnUsuarioYLoGuardo(){
        //Given
        User user= new User("1","2","juan","amigo@amigo","617929803","calle",null);
        //When
        createUserUseCase.execute(user);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).createUser(user);
    }
}