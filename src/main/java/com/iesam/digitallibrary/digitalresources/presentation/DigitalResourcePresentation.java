package com.iesam.digitallibrary.digitalresources.presentation;

import com.iesam.digitallibrary.digitalresources.domain.book.presentation.BookPresentation;

import java.util.Scanner;

public class DigitalResourcePresentation {
    public static void menuResource(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Entrar al apartado de libros ");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                BookPresentation.menuBook();
                break;
        }
    }
}
