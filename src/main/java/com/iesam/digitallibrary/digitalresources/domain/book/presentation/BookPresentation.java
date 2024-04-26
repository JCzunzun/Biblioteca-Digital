package com.iesam.digitallibrary.digitalresources.domain.book.presentation;

import com.iesam.digitallibrary.digitalresources.domain.book.data.BookDataRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.CreateBookUseCase;

import java.util.Scanner;

public class BookPresentation {
    public static void menuBook(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Crear Libro ");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                System.out.println("Digite el id del libro");
                String id=sc.next();
                System.out.println("Digite el nombre del libro");
                String name= sc.next();
                System.out.println("Ponga el estado de deterioro del libro");
                String stateOfDeterioration=sc.next();
                System.out.println("Digite el autor del libro");
                String autor=sc.next();
                System.out.println("Digite el numero de paginas");
                String numberOfPages=sc.next();
                System.out.println("Descripcion del libro");
                String description=sc.next();
                System.out.println("Genero del libro");
                String gender= sc.next();
                createBook(new Book(id,name,stateOfDeterioration,autor,numberOfPages,description,gender));
                break;
        }
    }
    private static void createBook(Book book){
        CreateBookUseCase createBookUseCase = new CreateBookUseCase(new BookDataRepository(new BookFileLocalDataSource()));
        createBookUseCase.execute(book);
    }
}
