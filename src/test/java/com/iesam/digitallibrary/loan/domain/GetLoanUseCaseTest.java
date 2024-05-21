package com.iesam.digitallibrary.loan.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    GetLoanUseCase getLoanUseCase;

    @BeforeEach
    public void setUp(){
        getLoanUseCase= new GetLoanUseCase(loanRepository);
    }
    public void clear(){
        getLoanUseCase=null;
    }

    @Test
    public void siElIdPrestamoSiExisteLoDevuelvo(){
        //Given
        Loan loanExpected= new Loan("1","1","1");
        Mockito.when(loanRepository.obtainSpecifiedLoan("1")).thenReturn(loanExpected);

        //When
        Loan loanReceived= getLoanUseCase.execute("1");

        //Then
        Assertions.assertEquals(loanReceived.idLoan,"1");
        Assertions.assertEquals(loanReceived.idUser,"1");
        Assertions.assertEquals(loanReceived.idDigitalResource,"1");
        Assertions.assertEquals(loanReceived.statusLoan,"Finished");
    }

    @Test
    public void siElIdNoLlevaANingunPrestamoDevuelveNulo(){
        //Given
        String idExpect="1";
        Mockito.when(loanRepository.obtainSpecifiedLoan(idExpect)).thenReturn(null);

        //When
        Loan loanReceived=loanRepository.obtainSpecifiedLoan(idExpect);

        //Then
        Assertions.assertNull(loanReceived);
        Mockito.verify(loanRepository, Mockito.times(1)).obtainSpecifiedLoan(idExpect);
    }
}