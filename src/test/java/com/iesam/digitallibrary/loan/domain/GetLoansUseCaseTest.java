package com.iesam.digitallibrary.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetLoansUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    GetLoansUseCase getLoansUseCase;
    @BeforeEach
    public void setUp(){
        getLoansUseCase=new GetLoansUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        getLoansUseCase=null;
    }
    @Test
    public void siReciboUnaListaLaCompruebo(){
        //Given
        Loan loan1= new Loan("1","1","1");
        Loan loan2= new Loan("2","2","2");
        ArrayList<Loan> loansExpected= new ArrayList<>();
        loansExpected.add(loan1);
        loansExpected.add(loan2);
        Mockito.when(loanRepository.obtainLoans()).thenReturn(loansExpected);

        //When
        ArrayList<Loan> loansReceived=getLoansUseCase.execute();

        //Then
        Assertions.assertEquals(loansExpected.size(),loansReceived.size());

        Assertions.assertEquals(loansReceived.get(0).idLoan,"1");
        Assertions.assertEquals(loansReceived.get(0).idUser,"1");
        Assertions.assertEquals(loansReceived.get(0).idDigitalResource,"1");
        Assertions.assertEquals(loansReceived.get(0).statusLoan,"Pending");
        Assertions.assertEquals(loansReceived.get(1).idLoan,"2");
        Assertions.assertEquals(loansReceived.get(1).idUser,"2");
        Assertions.assertEquals(loansReceived.get(1).idDigitalResource,"2");
        Assertions.assertEquals(loansReceived.get(1).statusLoan,"Finished");
    }

    @Test
    public void siNoReciboUnaListaDevuelvoNulo(){
        //Given
        Mockito.when(loanRepository.obtainLoans()).thenReturn(null);

        //When
        ArrayList<Loan> loansReceived=loanRepository.obtainLoans();

        //Then
        Assertions.assertNull(loansReceived);
        Mockito.verify(loanRepository, Mockito.times(1)).obtainLoans();
    }
}