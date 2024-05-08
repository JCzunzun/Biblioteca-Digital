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
class DeleteUserUserCaseTest {
    @Mock
    UserRepository userRepository;

    DeleteUserUserCase deleteUserUserCase;
    @BeforeEach
    public void setUp(){
        deleteUserUserCase= new DeleteUserUserCase(userRepository);
    }
    @AfterEach
    public void clear(){
        deleteUserUserCase=null;
    }
    @Test
    public void mePasanUnIdComprueboQueSeEjecuta(){
        //Given
        String userIdDelete="10";

        //When
        deleteUserUserCase.execute(userIdDelete);

        //Then
        Mockito.verify(userRepository,Mockito.times(1)).deleteUser(userIdDelete);
    }
}