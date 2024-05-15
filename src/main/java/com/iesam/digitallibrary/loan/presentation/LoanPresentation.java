package com.iesam.digitallibrary.loan.presentation;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LoanPresentation {
    public static void menu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir " +
                "\n1: Crear prestamos" +
                "\n2: Eliminar un prestamo" +
                "\n3: Obtener listado de prestamos pendientes" +
                "\n4: Obtener listado de prestamos finalizados" +
                "\n5: Obtener un listado de todos los prestamos" +
                "\n6: Finalizar un prestamo");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                System.out.println("Digite el id del prestamo");
                String idPrestamo= sc.next();
                System.out.println("Digite el id del usuario a quien se hara el prestamo");
                String userPrestamos= sc.next();
                System.out.println("Digite el id del recurso a prestar");
                String recursoPrestamo= sc.next();
                createLoan(new Loan(idPrestamo, userPrestamos, recursoPrestamo));
                break;
            case 2:
                System.out.println("Digite el identificador del prestamo");
                String idLoanDelete= sc.next();
                deleteLoan(idLoanDelete);
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
                System.out.println("Digite el id del prestamo a finalizar");
                String idFinish=sc.next();
                endedLoan(idFinish);
                break;
            default:
                break;
        }
    }
    private static void createLoan (Loan loan){
        CreateLoanUseCase createLoanUseCase= new CreateLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        createLoanUseCase.execute(loan);
    }
    private static void deleteLoan(String id){
        DeleteLoanUseCase deleteLoanUseCase= new DeleteLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        deleteLoanUseCase.execute(id);
    }
    private static void obtainPendingLoans(){
        GetLoansPendingUseCase getLoansPendingUseCase = new GetLoansPendingUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loans=getLoansPendingUseCase.execute();
        for(Loan loan:loans){
            System.out.println(loan);
        }
    }
    private static void obtainFinishedLoans(){
        GetFinishedLoansUseCase getFinishedLoansUseCase= new GetFinishedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loans=getFinishedLoansUseCase.execute();
        for(Loan loan:loans){
            System.out.println(loan);
        }
    }
    private static void endedLoan(String id){
        EndedLoanUseCase endedLoanUseCase= new EndedLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        endedLoanUseCase.execute(id);

    }
    private static void obtainLoans(){
        ArrayList<Loan> loans;
        GetLoansUseCase getLoansUseCase= new GetLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        loans=getLoansUseCase.execute();
        for(Loan loan: loans){
            System.out.println(loan);
        }
    }
}
