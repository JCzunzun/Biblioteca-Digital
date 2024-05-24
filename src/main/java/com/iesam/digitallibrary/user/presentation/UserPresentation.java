package com.iesam.digitallibrary.user.presentation;

import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.user.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPresentation {
    private static Scanner sc = new Scanner(System.in);
    private final UserFactoryPresentation userFactoryPresentation;

    public UserPresentation(UserFactoryPresentation userFactoryPresentation) {
        this.userFactoryPresentation = userFactoryPresentation;
    }

    public void menu() {

        System.out.println("0: Salir " +
                "\n1: Crear Usuario " +
                "\n2: Borrar usuario " +
                "\n3: Modificar un usuario " +
                "\n4: Obtener un listado de usuario" +
                "\n5: Obtener un usuario especifico" +
                "\n6: Obtener los prestamos de un usuario");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 0:
                break;
            case 1:
                System.out.println("Digite el id");
                String id = sc.next();
                System.out.println("Digite el dni");
                String dni = sc.next();
                System.out.println("Digite el nombre");
                String name = sc.next();
                System.out.println("Digite el email");
                String email = sc.next();
                System.out.println("Digite el numero de telefono");
                String phone = sc.next();
                System.out.println("Digite la direccion");
                String address = sc.next();
                createUser(new User(id, dni, name, email, phone, address, null));
                break;

            case 2:
                System.out.println("Digite el id del usuario a eliminar");
                String idDelete = sc.next();
                deleteUser(idDelete);
                break;

            case 3:
                System.out.println("Digite el nuevo id");
                String idModified = sc.next();
                System.out.println("Digite el dni");
                String dniModified = sc.next();
                System.out.println("Digite el nombre");
                String nameModified = sc.next();
                System.out.println("Digite el email");
                String emailModified = sc.next();
                System.out.println("Digite el numero de telefono");
                String phoneModified = sc.next();
                System.out.println("Digite la direccion");
                String addressModiofied = sc.next();
                modifyUser(new User(idModified, dniModified, nameModified, emailModified, phoneModified, addressModiofied, null));
                break;

            case 4:
                getsUsers();
                break;

            case 5:
                System.out.println("Digite el id del usuario");
                String idSearch = sc.next();
                getUser(idSearch);
                break;

            case 6:
                System.out.println("Digite el id del usuario");
                String idForLoan = sc.next();
                getLoansOfUser(idForLoan);
                break;

            default:
                break;

        }
    }

    public void createUser(User user) {

        CreateUserUseCase createUserUseCase = userFactoryPresentation.buildCreateUserCase();
        createUserUseCase.execute(user);
    }

    public void deleteUser(String id) {

        DeleteUserUserCase deleteUserUserCase = userFactoryPresentation.buildDeleteUserUseCase();
        deleteUserUserCase.execute(id);
    }

    public void modifyUser(User user) {
        ModifyUserUseCase modifyUserUseCase = userFactoryPresentation.buildModifyUserUseCase();
        modifyUserUseCase.execute(user);
    }

    public void getsUsers() {
        GetsUsersUseCase getsUsersUseCase = userFactoryPresentation.buildGetsUsersUseCase();
        ArrayList<User> users = getsUsersUseCase.execute();
        for (User user : users) {
            System.out.println(user);
        }

    }

    public void getUser(String id) {

        GetUserUseCase getUserUseCase = userFactoryPresentation.buildGetUserUseCase();
        User user = getUserUseCase.execute(id);
        System.out.println(user);
    }

    public void getLoansOfUser(String id) {

        GetLoansOfUserUseCase loansOfUserUseCase = userFactoryPresentation.buildGetLoansOfUserUseCase();
        ArrayList<Loan> loans = loansOfUserUseCase.execute(id);
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }
    }
}
