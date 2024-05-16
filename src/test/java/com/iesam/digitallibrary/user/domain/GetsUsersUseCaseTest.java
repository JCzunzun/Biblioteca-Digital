package com.iesam.digitallibrary.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetsUsersUseCaseTest {
    @Mock
    UserRepository userRepository;

    GetsUsersUseCase getsUsersUseCase;
    @BeforeEach
    public void setUp(){
        getsUsersUseCase= new GetsUsersUseCase(userRepository);
    }
    @AfterEach
    public void clear(){
        getsUsersUseCase=null;
    }
    @Test
    public void comprueboSiMeDevuelvenUnaListaCorrecta(){
        //Given
        ArrayList<User> userSimnulation= new ArrayList<>();
        userSimnulation.add(new User("1","a","juan","juan@juan","617929803","Calle",""));
        userSimnulation.add(new User("2","b","camilo","camilo@camilo","617853702","Calle",""));
        Mockito.when(userRepository.getUsers()).thenReturn(userSimnulation);
        //When
        ArrayList<User> usersReceived=getsUsersUseCase.execute();
        //Then
        Assertions.assertEquals(usersReceived.size(),userSimnulation.size());

        Assertions.assertEquals(usersReceived.get(0).id,"1");
        Assertions.assertEquals(usersReceived.get(0).dni,"a");
        Assertions.assertEquals(usersReceived.get(0).name,"juan");
        Assertions.assertEquals(usersReceived.get(0).email,"juan@juan");
        Assertions.assertEquals(usersReceived.get(0).phone,"617929803");
        Assertions.assertEquals(usersReceived.get(0).addres,"Calle");
        Assertions.assertEquals(usersReceived.get(0).loanActives,"");
        Assertions.assertEquals(usersReceived.get(1).id,"2");
        Assertions.assertEquals(usersReceived.get(1).dni,"b");
        Assertions.assertEquals(usersReceived.get(1).name,"camilo");
        Assertions.assertEquals(usersReceived.get(1).email,"camilo@camilo");
        Assertions.assertEquals(usersReceived.get(1).phone,"617853702");
        Assertions.assertEquals(usersReceived.get(1).addres,"Calle");
        Assertions.assertEquals(usersReceived.get(1).loanActives,"");
    }
    @Test
    public void siNoExisteUnaListaDevuelveNull(){
        //Given
        Mockito.when(userRepository.getUsers()).thenReturn(null);

        //When
        ArrayList<User> userReceived= getsUsersUseCase.execute();

        //Then
        Assertions.assertNull(userReceived);
    }

}