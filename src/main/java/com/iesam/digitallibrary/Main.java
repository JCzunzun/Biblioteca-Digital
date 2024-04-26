package com.iesam.digitallibrary;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.presentation.DigitalResourcePresentation;
import com.iesam.digitallibrary.user.presentation.UserPresentation;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Para salir " +
                "\n1: Para acceder al apartado de usuarios" +
                "\n2: Para acceder al apartado de recursos digitales");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                UserPresentation.menu();
                break;
            case 2:
                DigitalResourcePresentation.menuResource();
                break;
        }
    }
}