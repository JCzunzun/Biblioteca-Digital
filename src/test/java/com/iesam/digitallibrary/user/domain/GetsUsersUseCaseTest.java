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

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
        userSimnulation.add(new User("1","a","juan","juan@juan","617929803","Calle",null));
        userSimnulation.add(new User("2","b","camilo","camilo@camilo","617853702","Calle",null));
        Mockito.when(userRepository.getUsers()).thenReturn(userSimnulation);
        //When
        ArrayList<User> usersReceived=getsUsersUseCase.execute();
        //Then
        Mockito.verify(userRepository,Mockito.times(1)).getUsers();

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
        Mockito.verify(userRepository,Mockito.times(1)).getUsers();
        Assertions.assertNull(userReceived);
    }
    @Test
    public void obtenerUnListadoEnMemoria() {
        UserMemLocalDataSource memLocalDataSource = mock(UserMemLocalDataSource.class);
        UserFileLocalDataSource fileLocalDataSource = mock(UserFileLocalDataSource.class);

        UserDataRepository repository = new UserDataRepository(fileLocalDataSource, memLocalDataSource);

        ArrayList<User> usersExpected = new ArrayList<>();
        Collections.addAll(usersExpected, new User("1", null,null,null,null,null,null),
                new User("2", null,null,null,null, null,null));

        Mockito.when(memLocalDataSource.getUsers()).thenReturn(usersExpected);

        ArrayList<User> result = repository.getUsers();

        assertEquals(usersExpected.get(0).getId(), "1");
        assertEquals(usersExpected.get(1).getId(),"2");
        Mockito.verify(memLocalDataSource, Mockito.times(1)).getUsers();
        Mockito.verify(fileLocalDataSource, Mockito.never()).getUsers();
    }
    @Test
    public void obtenerUnListadoDelFichero() {
        //Given
        UserMemLocalDataSource memLocalDataSource = mock(UserMemLocalDataSource.class);
        UserFileLocalDataSource fileLocalDataSource = mock(UserFileLocalDataSource.class);

        UserDataRepository repository = new UserDataRepository(fileLocalDataSource, memLocalDataSource);
        ArrayList<User> usersExpected = new ArrayList<>();
        Collections.addAll(usersExpected, new User("1", null,null,null,null,null,null),
                new User("2", null,null,null,null, null,null));



        Mockito.when(fileLocalDataSource.getUsers()).thenReturn(usersExpected);
        //When
        ArrayList<User> usersReceived = repository.getUsers();

        //Then
        assertEquals(usersReceived.get(0).getId(), "1");
        assertEquals(usersReceived.get(1).getId(),"2");
        Mockito.verify(memLocalDataSource, Mockito.times(1)).getUsers();
        Mockito.verify(fileLocalDataSource, Mockito.times(1)).getUsers();
        for (User user : usersExpected) {
            Mockito.verify(memLocalDataSource, Mockito.times(1)).createUser(user);
        }


    }

}