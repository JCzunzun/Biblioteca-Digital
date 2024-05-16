package com.iesam.digitallibrary.digitalresources.domain.book.presentation;

import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.data.BookDataRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BookPresentation {
    public static void menuBook(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir " +
                "\n1: Crear Libro " +
                "\n2: Eliminar un libro" +
                "\n3: Modificar un libro" +
                "\n4: Obtener un listado de los libros");
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
                String tipo="Libro";
                createBook(new Book(id,name,stateOfDeterioration,autor,tipo,numberOfPages,description,gender));
                break;

            case 2:
                System.out.println("Digite el id del libro que quiere borrar");
                String idDelete= sc.next();
                deleteBook(idDelete);
                break;

            case 3:
                System.out.println("Digite el id del libro");
                String idUpdate=sc.next();
                System.out.println("Digite el nombre del libro");
                String nameUpdate= sc.next();
                System.out.println("Ponga el estado de deterioro del libro");
                String stateOfDeteriorationUpdate=sc.next();
                System.out.println("Digite el autor del libro");
                String autorUpdate=sc.next();
                System.out.println("Digite el numero de paginas");
                String numberOfPagesUpdate=sc.next();
                System.out.println("Descripcion del libro");
                String descriptionUpdate=sc.next();
                System.out.println("Genero del libro");
                String genderUpdate= sc.next();
                String tipoUpdate="Libro";
                modifiedBook(new Book(idUpdate,nameUpdate,stateOfDeteriorationUpdate,autorUpdate,tipoUpdate,numberOfPagesUpdate,descriptionUpdate,genderUpdate));
                break;

            case 4:
                getsBooks();
                break;
        }
    }
    private static void createBook(Book book){
        CreateBookUseCase createBookUseCase = new CreateBookUseCase(new BookDataRepository(new DigitalResourceFileLocalDataSource()));
        createBookUseCase.execute(book);
    }
    private static void deleteBook(String id){
        DeleteBookUseCase deleteBookUseCase= new DeleteBookUseCase(new BookDataRepository(new DigitalResourceFileLocalDataSource()));
        deleteBookUseCase.execute(id);
    }
    private static void modifiedBook(Book book){
        ModifyBookUseCase modifyBookUseCase = new ModifyBookUseCase(new BookDataRepository(new DigitalResourceFileLocalDataSource()));
        modifyBookUseCase.execute(book);
    }
    private static void getsBooks(){
        GetsBooksUseCase getsBooksUseCase= new GetsBooksUseCase(new BookDataRepository(new DigitalResourceFileLocalDataSource()));
        ArrayList <Book> books= getsBooksUseCase.execute();
        for(Book book:books){
            System.out.println(book);
        }
    }
}
