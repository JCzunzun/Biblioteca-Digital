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
class ModifyUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    ModifyUserUseCase modifyUserUseCase;
    @BeforeEach
    public void setUp(){
        modifyUserUseCase= new ModifyUserUseCase(userRepository);
    }
    @AfterEach
    public void clear(){
        modifyUserUseCase=null;
    }
    @Test
    public void reciboUnUsuarioYLoGuardo(){
        //Given
        User user= new User("1","2","juan","amigo@amigo","617929803","calle",null);
        //When
        modifyUserUseCase.execute(user);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).modifyUser(user);
    }

}