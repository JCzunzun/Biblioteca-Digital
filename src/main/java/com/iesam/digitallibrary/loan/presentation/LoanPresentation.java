package com.iesam.digitallibrary.loan.presentation;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.CreateLoanUseCase;
import com.iesam.digitallibrary.loan.domain.DeleteLoanUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;

import java.util.Scanner;

public class LoanPresentation {
    public static void menu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir " +
                "\n1: Crear prestamos" +
                "\n2: Eliminar un prestamo");
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
                System.out.println("Estado del prestamo");
                String estadoPrestamo=sc.next();
                System.out.println("Fecha de inicio del prestamo");
                String inicioPrestamo=sc.next();
                System.out.println("Fecha maxima de entrega del prestamo");
                String finPrestamo=sc.next();
                createLoan(new Loan(idPrestamo, userPrestamos,recursoPrestamo,estadoPrestamo,inicioPrestamo,finPrestamo));
                break;
            case 2:
                System.out.println("Digite el identificador del prestamo");
                String idLoanDelete= sc.next();
                deleteLoan(idLoanDelete);
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
}
