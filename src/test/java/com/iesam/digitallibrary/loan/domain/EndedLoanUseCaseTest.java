package com.iesam.digitallibrary.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EndedLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    EndedLoanUseCase endedLoanUseCase;

    @BeforeEach
    public void setUp(){
        endedLoanUseCase=new EndedLoanUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        endedLoanUseCase=null;
    }

    @Test
    public void meDanUnIdYModificoElPrestamo(){
        //Given
        String idModi="2";
        Loan loan= new Loan("a","1","r1","a","a");

        //When
        endedLoanUseCase.execute(idModi);

        //Then
        Mockito.verify(loanRepository,Mockito.times(1)).endedLoan(idModi);
    }
}