package com.iesam.digitallibrary.user.presentation;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.user.domain.*;

public class UserFactoryPresentation {

    private UserMemLocalDataSource userMemLocalDataSource = new UserMemLocalDataSource();
    private UserFileLocalDataSource userFileLocalDataSource = new UserFileLocalDataSource();
    private UserDataRepository userDataRepository;

    public UserFactoryPresentation() {
        this.userDataRepository = new UserDataRepository(userFileLocalDataSource, userMemLocalDataSource);
    }

    public CreateUserUseCase buildCreateUserCase() {
        return new CreateUserUseCase(userDataRepository);
    }
    public DeleteUserUserCase buildDeleteUserUseCase(){
        return new DeleteUserUserCase(userDataRepository);
    }

    public ModifyUserUseCase buildModifyUserUseCase(){
        return new ModifyUserUseCase(userDataRepository);
    }
    public GetsUsersUseCase buildGetsUsersUseCase(){
        return new GetsUsersUseCase(userDataRepository);
    }
    public GetUserUseCase buildGetUserUseCase(){
        return new GetUserUseCase(userDataRepository);
    }
    public GetLoansOfUserUseCase buildGetLoansOfUserUseCase(){
        return new GetLoansOfUserUseCase(userDataRepository);
    }
}
