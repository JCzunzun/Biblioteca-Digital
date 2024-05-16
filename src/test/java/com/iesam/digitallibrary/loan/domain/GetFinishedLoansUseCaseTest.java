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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetFinishedLoansUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    GetFinishedLoansUseCase getFinishedLoansUseCase;
    @BeforeEach
    public void setUp(){
        getFinishedLoansUseCase=new GetFinishedLoansUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        getFinishedLoansUseCase=null;
    }
    @Test
    public void siReciboUnaListaLaCompruebo(){
        //Given
        Loan loan1= new Loan("1","1","1");
        loan1.setStatusLoan("Finished");
        Loan loan2= new Loan("2","2","2");
        loan2.setStatusLoan("Finished");
        ArrayList<Loan> loansExpected= new ArrayList<>();
        loansExpected.add(loan1);
        loansExpected.add(loan2);
        Mockito.when(loanRepository.obtainFinishedLoans()).thenReturn(loansExpected);

        //When
        ArrayList<Loan> loansReceived=getFinishedLoansUseCase.execute();

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).obtainFinishedLoans();

        Assertions.assertEquals(loansExpected.size(),loansReceived.size());

        Assertions.assertEquals(loansReceived.get(0).getIdLoan(),"1");
        Assertions.assertEquals(loansReceived.get(0).getIdUser(),"1");
        Assertions.assertEquals(loansReceived.get(0).getIdDigitalResource(),"1");
        Assertions.assertEquals(loansReceived.get(0).getStatusLoan(),"Finished");
        Assertions.assertEquals(loansReceived.get(1).getIdLoan(),"2");
        Assertions.assertEquals(loansReceived.get(1).getIdUser(),"2");
        Assertions.assertEquals(loansReceived.get(1).getIdDigitalResource(),"2");
        Assertions.assertEquals(loansReceived.get(1).getStatusLoan(),"Finished");
    }

    @Test
    public void siNoReciboUnaListaDevuelvoNulo(){
        //Given
        Mockito.when(loanRepository.obtainFinishedLoans()).thenReturn(null);

        //When
        ArrayList<Loan> loansReceived=loanRepository.obtainFinishedLoans();

        //Then
        Assertions.assertNull(loansReceived);
    }

}