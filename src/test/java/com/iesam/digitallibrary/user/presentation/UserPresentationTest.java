package com.iesam.digitallibrary.user.presentation;

import com.iesam.digitallibrary.user.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserPresentationTest {

    @Mock
    UserFactoryPresentation userFactoryPresentation;

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserPresentation userPresentation;


    CreateUserUseCase createUserUseCase;
    DeleteUserUserCase deleteUserUserCase;
    GetsUsersUseCase getsUsersUseCase;
    GetUserUseCase getUserUseCase;
    ModifyUserUseCase modifyUserUseCase;
    GetLoansOfUserUseCase loansOfUserUseCase;


    @BeforeEach
    public void setUp(){
        userPresentation= new UserPresentation(userFactoryPresentation);
        createUserUseCase= new CreateUserUseCase(userRepository);
        deleteUserUserCase=new DeleteUserUserCase(userRepository);
        modifyUserUseCase= new ModifyUserUseCase(userRepository);
        getsUsersUseCase= new GetsUsersUseCase(userRepository);
        getUserUseCase= new GetUserUseCase(userRepository);
        loansOfUserUseCase= new GetLoansOfUserUseCase(userRepository);
    }


    @AfterEach
    public void clear(){
        userPresentation=null;
        createUserUseCase=null;
        deleteUserUserCase=null;
        modifyUserUseCase=null;
        getsUsersUseCase=null;
        getUserUseCase=null;
        loansOfUserUseCase= null;
    }

    @Test
    public void whenShowForMethodUseCaseCollect(){
        //Given
        Mockito.when(userFactoryPresentation.buildCreateUserCase()).thenReturn(createUserUseCase);
        User user= new User("1","9999919","juan","camilo@camilo","8901989","calle",null);

        //When
        userPresentation.createUser(user);


        //Then
        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildCreateUserCase();
        Mockito.verify(userRepository,Mockito.times(1)).createUser(user);
    }
    @Test
    public void whenShowForMethodUseCaseDelete(){
        Mockito.when(userFactoryPresentation.buildDeleteUserUseCase()).thenReturn(deleteUserUserCase);
        String idDelete="1";

        userPresentation.deleteUser(idDelete);

        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildDeleteUserUseCase();
        Mockito.verify(userRepository,Mockito.times(1)).deleteUser(idDelete);
    }
    @Test
    public void whenShowForMethodUseCaseModify(){
        Mockito.when(userFactoryPresentation.buildModifyUserUseCase()).thenReturn(modifyUserUseCase);
        User user= new User("1","9999919","juan","camilo@camilo","8901989","calle",null);


        userPresentation.modifyUser(user);

        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildModifyUserUseCase();
        Mockito.verify(userRepository,Mockito.times(1)).modifyUser(user);
    }
    @Test
    public void whenShowForMethodUseCaseObtainList(){
        Mockito.when(userFactoryPresentation.buildGetsUsersUseCase()).thenReturn(getsUsersUseCase);

        userPresentation.getsUsers();

        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildGetsUsersUseCase();
        Mockito.verify(userRepository,Mockito.times(1)).getUsers();

    }
    @Test
    public void whenShowForMethodUseCaseObtainUser(){
        Mockito.when(userFactoryPresentation.buildGetUserUseCase()).thenReturn(getUserUseCase);
        String id="1";

        userPresentation.getUser(id);

        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildGetUserUseCase();
        Mockito.verify(userRepository,Mockito.times(1)).getUser(id);
    }
    @Test
    public void whenShowForMethodUseCaseObtainLoansOfUser(){
        Mockito.when(userFactoryPresentation.buildGetLoansOfUserUseCase()).thenReturn(loansOfUserUseCase);
        String id="1";

        userPresentation.getLoansOfUser(id);

        Mockito.verify(userFactoryPresentation,Mockito.times(1)).buildGetLoansOfUserUseCase();
        Mockito.verify(userRepository,Mockito.times(1)).getLoansOfUser(id);
    }
}