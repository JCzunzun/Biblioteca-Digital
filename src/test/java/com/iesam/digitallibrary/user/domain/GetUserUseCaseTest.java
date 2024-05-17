package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

        Mockito.verify(userRepository, Mockito.times(1)).getUser("1");
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
        Mockito.verify(userRepository, Mockito.times(1)).getUser(userDniNotValid);
        Assertions.assertNull(userReceived);
    }
    @Test
    public void verificoSiElUsuarioVieneDeMemoria(){
        //Given
        UserMemLocalDataSource userMemLocalDataSource=mock(UserMemLocalDataSource.class);
        UserFileLocalDataSource userFileLocalDataSource=mock(UserFileLocalDataSource.class);

        UserDataRepository repository= new UserDataRepository(userFileLocalDataSource,userMemLocalDataSource);
        User userFk= new User("1",null,null,null,null,null,null);

        Mockito.when(userMemLocalDataSource.getUser("1")).thenReturn(userFk);

        //When
        User userReceived=repository.getUser("1");

        //Then
        Assertions.assertEquals(userReceived.getId(),"1");
        Mockito.verify(userMemLocalDataSource, Mockito.times(1)).getUser("1");
        Mockito.verify(userFileLocalDataSource,Mockito.never()).getUser("1");
    }
    @Test
    public void verificoSiElUsuarioVieneDelFichero(){
        //Given
        UserMemLocalDataSource userMemLocalDataSource=mock(UserMemLocalDataSource.class);
        UserFileLocalDataSource userFileLocalDataSource=mock(UserFileLocalDataSource.class);

        UserDataRepository repository= new UserDataRepository(userFileLocalDataSource,userMemLocalDataSource);
        User userFk= new User("1",null,null,null,null,null,null);

        when(userFileLocalDataSource.getUser("1")).thenReturn(userFk);

        //When
        User userReceived=repository.getUser("1");

        //Then
        Assertions.assertEquals(userReceived.getId(),"1");
        Mockito.verify(userFileLocalDataSource, Mockito.times(1)).getUser("1");
        Mockito.verify(userMemLocalDataSource,Mockito.times(1)).getUser("1");
        Mockito.verify(userMemLocalDataSource,Mockito.times(1)).createUser(userFk);
    }
    @Test
    public void comprueboSiElIdNoSeEncuentraNiEnFicheroNiEnMemoriaYDevuelvoNulo(){
        //Given
        UserMemLocalDataSource userMemLocalDataSource=mock(UserMemLocalDataSource.class);
        UserFileLocalDataSource userFileLocalDataSource=mock(UserFileLocalDataSource.class);

        UserDataRepository repository= new UserDataRepository(userFileLocalDataSource,userMemLocalDataSource);

        Mockito.when(userMemLocalDataSource.getUser("1")).thenReturn(null);
        Mockito.when(userFileLocalDataSource.getUser("1")).thenReturn(null);

        //When
        User userReceived=repository.getUser("1");

        //Then
        Assertions.assertNull(userReceived);
        Mockito.verify(userMemLocalDataSource, Mockito.times(1)).getUser("1");
        Mockito.verify(userFileLocalDataSource,Mockito.times(1)).getUser("1");
    }


}