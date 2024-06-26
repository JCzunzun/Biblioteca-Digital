package com.iesam.digitallibrary.digitalresources.domain.book.presentation;

import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.data.BookDataRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BookPresentation {
    private static Scanner sc = new Scanner(System.in);

    public static void menuBook() {

        System.out.println("0: Salir " +
                "\n1: Crear Libro " +
                "\n2: Eliminar un libro" +
                "\n3: Modificar un libro" +
                "\n4: Obtener un listado de los libros" +
                "\n5: Obtener un libro especifico");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 0:
                break;
            case 1:

                createBook();
                break;

            case 2:

                deleteBook();
                break;

            case 3:

                modifiedBook();
                break;

            case 4:
                getsBooks();
                break;
            case 5:
                getBook();

        }
    }

    private static void createBook() {
        System.out.println("Digite el id del libro");
        String id = sc.next();
        System.out.println("Digite el nombre del libro");
        String name = sc.next();
        System.out.println("Ponga el estado de deterioro del libro");
        String stateOfDeterioration = sc.next();
        System.out.println("Digite el autor del libro");
        String autor = sc.next();
        System.out.println("Digite el numero de paginas");
        String numberOfPages = sc.next();
        System.out.println("Descripcion del libro");
        String description = sc.next();
        System.out.println("Genero del libro");
        String gender = sc.next();
        Book book = new Book(id, name, stateOfDeterioration, autor, numberOfPages, description, gender);
        CreateBookUseCase createBookUseCase = new CreateBookUseCase(new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        createBookUseCase.execute(book);
    }

    private static void deleteBook() {
        System.out.println("Digite el id del libro que quiere borrar");
        String idDelete = sc.next();
        DeleteBookUseCase deleteBookUseCase = new DeleteBookUseCase(new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        deleteBookUseCase.execute(idDelete);
    }

    private static void modifiedBook() {
        System.out.println("Digite el id del libro");
        String idUpdate = sc.next();
        System.out.println("Digite el nombre del libro");
        String nameUpdate = sc.next();
        System.out.println("Ponga el estado de deterioro del libro");
        String stateOfDeteriorationUpdate = sc.next();
        System.out.println("Digite el autor del libro");
        String autorUpdate = sc.next();
        System.out.println("Digite el numero de paginas");
        String numberOfPagesUpdate = sc.next();
        System.out.println("Descripcion del libro");
        String descriptionUpdate = sc.next();
        System.out.println("Genero del libro");
        String genderUpdate = sc.next();
        Book book = new Book(idUpdate, nameUpdate, stateOfDeteriorationUpdate, autorUpdate, numberOfPagesUpdate, descriptionUpdate, genderUpdate);
        ModifyBookUseCase modifyBookUseCase = new ModifyBookUseCase(new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        modifyBookUseCase.execute(book);
    }

    private static void getsBooks() {
        GetsBooksUseCase getsBooksUseCase = new GetsBooksUseCase(new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        ArrayList<Book> books = getsBooksUseCase.execute();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void getBook() {
        System.out.println("Digite el id del libro a visualizar");
        String id = sc.next();
        GetBookUseCase getBookUseCase = new GetBookUseCase(new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        Book book = getBookUseCase.execute(id);
        System.out.println(book.toString());
    }
}
