package com.iesam.digitallibrary.loan.presentation;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.CreateLoanUseCase;
import com.iesam.digitallibrary.loan.domain.DeleteLoanUseCase;
import com.iesam.digitallibrary.loan.domain.GetLoansPendingUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;

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
                "\n3: Obtener listado de prestamos pendientes");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Digite el id del prestamo");
                String idPrestamo= sc.next();
                System.out.println("Digite el id del usuario a quien se hara el prestamo");
                String userPrestamos= sc.next();
                System.out.println("Digite el id del recurso a prestar");
                String recursoPrestamo= sc.next();
                System.out.println("Estado del prestamo");
                String estadoPrestamo=sc.next();
                try {
                    System.out.println("Fecha de inicio del préstamo (DD/MM/YYYY):");
                    Date inicioPrestamo = formato.parse(sc.next());
                    System.out.println("Fecha máxima de entrega del préstamo (DD/MM/YYYY):");
                    Date finPrestamo = formato.parse(sc.next());
                    Calendar calFin = Calendar.getInstance();
                    calFin.setTime(finPrestamo);
                    calFin.set(Calendar.HOUR_OF_DAY, 23);
                    calFin.set(Calendar.MINUTE, 59);
                    calFin.set(Calendar.SECOND, 59);
                    calFin.set(Calendar.MILLISECOND, 999);
                    finPrestamo=calFin.getTime();
                    createLoan(new Loan(idPrestamo, userPrestamos, recursoPrestamo, estadoPrestamo, inicioPrestamo, finPrestamo));

                } catch (ParseException e) {
                    System.out.println("Error al analizar la fecha. Asegúrate de ingresarla en el formato correcto (DD/MM/YYYY).");
                }break;
            case 2:
                System.out.println("Digite el identificador del prestamo");
                String idLoanDelete= sc.next();
                deleteLoan(idLoanDelete);
                break;
            case 3:
                obtainPendingLoans();
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
}
