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
class CreateLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    CreateLoanUseCase createLoanUseCase;

    @BeforeEach
    public void setUp(){
        createLoanUseCase=new CreateLoanUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        createLoanUseCase=null;
    }
    @Test
    public void reciboUnPrestamoYLoGuardo(){
        //Given
        Loan loan= new Loan("1","1","1");

        //When
        createLoanUseCase.execute(loan);

        //Then
        Mockito.verify(loanRepository,Mockito.times(1)).createLoan(loan);
    }

}