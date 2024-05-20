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
class GetLoansPendingUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    GetLoansPendingUseCase getLoansPendingUseCase;
    @BeforeEach
    public void setUp(){
        getLoansPendingUseCase=new GetLoansPendingUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        getLoansPendingUseCase=null;
    }
    @Test
    public void siReciboUnaListaLaCompruebo(){
        //Given
        Loan loan1= new Loan("1","1","1");;
        Loan loan2= new Loan("2","2","2");
        ArrayList<Loan> loansExpected= new ArrayList<>();
        loansExpected.add(loan1);
        loansExpected.add(loan2);
        Mockito.when(loanRepository.obtainLoansPending()).thenReturn(loansExpected);

        //When
        ArrayList<Loan> loansReceived=getLoansPendingUseCase.execute();

        //Then
        Assertions.assertEquals(loansExpected.size(),loansReceived.size());

        Assertions.assertEquals(loansReceived.get(0).idLoan,"1");
        Assertions.assertEquals(loansReceived.get(0).idUser,"1");
        Assertions.assertEquals(loansReceived.get(0).idDigitalResource,"1");
        Assertions.assertEquals(loansReceived.get(0).statusLoan,"Pending");
        Assertions.assertEquals(loansReceived.get(1).idLoan,"2");
        Assertions.assertEquals(loansReceived.get(1).idUser,"2");
        Assertions.assertEquals(loansReceived.get(1).idDigitalResource,"2");
        Assertions.assertEquals(loansReceived.get(1).statusLoan,"Pending");
    }

    @Test
    public void siNoReciboUnaListaDevuelvoNulo(){
        //Given
        Mockito.when(loanRepository.obtainLoansPending()).thenReturn(null);

        //When
        ArrayList<Loan> loansReceived=loanRepository.obtainLoansPending();

        //Then
        Assertions.assertNull(loansReceived);
        Mockito.verify(loanRepository, Mockito.times(1)).obtainLoansPending();
    }
}