package com.iesam.digitallibrary.user.presentation;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.CreateUserUseCase;
import com.iesam.digitallibrary.user.domain.DeleteUserUserCase;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;

import java.util.Scanner;

public class UserPresentation {
    public void menu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Crear Usuario \n2: Borrar usuario \n3: Modificar un usuario");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                System.out.println("Digite el id");
                String id= sc.next();
                System.out.println("Digite el dni");
                String dni= sc.next();
                System.out.println("Digite el nombre");
                String name= sc.next();
                System.out.println("Digite el email");
                String email= sc.next();
                System.out.println("Digite el numero de telefono");
                String phone= sc.next();
                System.out.println("Digite la direccion");
                String address= sc.next();
                User user= new User(id,dni,name,email,phone,address,null);
                createUser(user);
                break;

            case 2:
                System.out.println("Digite el id del usuario a eliminar");
                String idDelete= sc.next();
                deleteUser(idDelete);
                break;

            case 3:
                System.out.println("Digite el id");
                String idModified= sc.next();
                System.out.println("Digite el dni");
                String dniModified= sc.next();
                System.out.println("Digite el nombre");
                String nameModified= sc.next();
                System.out.println("Digite el email");
                String emailModified= sc.next();
                System.out.println("Digite el numero de telefono");
                String phoneModified= sc.next();
                System.out.println("Digite la direccion");
                String addressModiofied= sc.next();
                User userModified= new User(idModified,dniModified,nameModified,emailModified,phoneModified,addressModiofied,null);
                modifyUser(userModified);
                break;
        }
    }
    public void createUser(User user){
        CreateUserUseCase createUserUseCase= new CreateUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        createUserUseCase.create(user);
    }
    public void deleteUser(String id){
        DeleteUserUserCase deleteUserUserCase= new DeleteUserUserCase(new UserDataRepository(new UserFileLocalDataSource()));
        deleteUserUserCase.delete(id);
    }
    public void modifyUser(User user){
        ModifyUserUseCase modifyUserUseCase= new ModifyUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        modifyUserUseCase.modify(user);
    }
}
