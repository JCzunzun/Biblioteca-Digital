package com.iesam.digitallibrary.user.presentation;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.CreateUserUseCase;
import com.iesam.digitallibrary.user.domain.User;

import java.util.Scanner;

public class UserPresentation {
    public static void menu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Crear Usuario");
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
        }
    }
    private static void createUser(User user){
        CreateUserUseCase createUserUseCase= new CreateUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        createUserUseCase.create(user);
    }
}
