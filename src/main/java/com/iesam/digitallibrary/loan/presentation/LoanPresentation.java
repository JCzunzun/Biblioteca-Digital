package com.iesam.digitallibrary.loan.presentation;

import com.iesam.digitallibrary.digitalresources.data.DigitalResourceDataRepository;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.GetAvailableDigitalResourceUseCase;
import com.iesam.digitallibrary.digitalresources.domain.book.data.BookDataRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.*;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.user.domain.GetUserUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LoanPresentation {
    private static Scanner sc = new Scanner(System.in);

    public static void menu() {

        System.out.println("0: Salir " +
                "\n1: Crear prestamos" +
                "\n2: Eliminar un prestamo" +
                "\n3: Obtener listado de prestamos pendientes" +
                "\n4: Obtener listado de prestamos finalizados" +
                "\n5: Obtener un listado de todos los prestamos" +
                "\n6: Finalizar un prestamo" +
                "\n7: Obtener informacion de un prestamo");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 0:
                break;
            case 1:
                createLoan();
                break;
            case 2:
                deleteLoan();
                break;
            case 3:
                obtainPendingLoans();
                break;
            case 4:
                obtainFinishedLoans();
                break;
            case 5:
                obtainLoans();
                break;
            case 6:
                endedLoan();
                break;
            case 7:
                obtainLoan();
                break;
            default:
                break;
        }
    }

    private static void createLoan() {
        GetAvailableDigitalResourceUseCase availableDigitalResourceUseCase = new GetAvailableDigitalResourceUseCase(
                new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource())
        );
        ArrayList<DigitalResource> resources = availableDigitalResourceUseCase.execute();
        System.out.println("Digite el id del prestamo");
        String idPrestamo = sc.next();
        System.out.println("Digite el id del usuario a quien se hara el prestamo");
        String userPrestamos = sc.next();
        System.out.println("Recursos disponibles: ");
        for (DigitalResource resource : resources) {
            System.out.println(resource.toString());
        }
        System.out.println("Digite el id del recurso a prestar");
        String recursoPrestamo = sc.next();
        Loan loan = new Loan(idPrestamo, userPrestamos, recursoPrestamo);
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()),
                new UserDataRepository(new UserFileLocalDataSource(), new UserMemLocalDataSource()),
                new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()),
                new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        createLoanUseCase.execute(loan);
    }


    private static void deleteLoan() {
        System.out.println("Digite el identificador del prestamo");
        String idLoanDelete = sc.next();
        DeleteLoanOfUserUseCase deleteLoanOfUserUseCase = new DeleteLoanOfUserUseCase
                (new LoanDataRepository(new LoanFileLocalDataSource()),
                        new UserDataRepository(new UserFileLocalDataSource(), new UserMemLocalDataSource()),
                        new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()),
                        new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        deleteLoanOfUserUseCase.execute(idLoanDelete);
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        deleteLoanUseCase.execute(idLoanDelete);
    }

    private static void obtainPendingLoans() {
        GetLoansPendingUseCase getLoansPendingUseCase = new GetLoansPendingUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loans = getLoansPendingUseCase.execute();
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }
    }

    private static void obtainFinishedLoans() {
        GetFinishedLoansUseCase getFinishedLoansUseCase = new GetFinishedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loans = getFinishedLoansUseCase.execute();
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }
    }

    private static void endedLoan() {
        System.out.println("Digite el id del prestamo a finalizar");
        String idFinish = sc.next();
        DeleteLoanOfUserUseCase deleteLoanOfUserUseCase = new DeleteLoanOfUserUseCase
                (new LoanDataRepository(new LoanFileLocalDataSource()),
                        new UserDataRepository(new UserFileLocalDataSource(), new UserMemLocalDataSource()),
                        new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()),
                        new BookDataRepository(new BookFileLocalDataSource(new DigitalResourceFileLocalDataSource())));
        deleteLoanOfUserUseCase.execute(idFinish);
        EndedLoanUseCase endedLoanUseCase = new EndedLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        endedLoanUseCase.execute(idFinish);

    }

    private static void obtainLoans() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loans = getLoansUseCase.execute();
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }
    }

    private static void obtainLoan() {
        System.out.println("Digite el id del prestamo a visualizar");
        String idVisual = sc.next();
        ;
        GetLoanUseCase getLoanUseCase = new GetLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        Loan loan = getLoanUseCase.execute(idVisual);
        System.out.println(loan.toString());

    }
}
