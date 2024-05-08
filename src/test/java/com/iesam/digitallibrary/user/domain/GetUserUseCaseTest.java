package com.iesam.digitallibrary.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    GetUserUseCase getUserUseCase;
    @BeforeEach
    public void setUp(){
        getUserUseCase= new GetUserUseCase(userRepository);
    }
    @AfterEach
    public void clear(){
        getUserUseCase=null;
    }
    @Test
    public void pasanUnIdValidoEntoncesDevuelvoUnUser(){
        //Given
        User userExpected= new User("1","00000000y","camilo","camilo@camilo","620111111","calle","null");
        Mockito.when(userRepository.getUser("1")).thenReturn(userExpected);

        //When
        User userReceived=getUserUseCase.execute("1");

        //Then
        Assertions.assertEquals(userReceived.id,"1");
        Assertions.assertEquals(userReceived.dni,"00000000y");
        Assertions.assertEquals(userReceived.name,"camilo");
        Assertions.assertEquals(userReceived.email,"camilo@camilo");
        Assertions.assertEquals(userReceived.phone,"620111111");
        Assertions.assertEquals(userReceived.addres,"calle");
        Assertions.assertEquals(userReceived.loanActives,"null");

    }
    @Test
    public void pasaUnIdInvalidoEntoncesDevuelveNulo(){
        //Given
        String userDniNotValid="50";
        Mockito.when(userRepository.getUser("50")).thenReturn(null);

        //When
        User userReceived=userRepository.getUser(userDniNotValid);

        //Then
        Assertions.assertNull(userReceived);
    }


}