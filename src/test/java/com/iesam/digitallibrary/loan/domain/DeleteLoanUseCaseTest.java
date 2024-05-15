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
class DeleteLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    DeleteLoanUseCase deleteLoanUseCase;

    @BeforeEach
    public void setUp(){
        deleteLoanUseCase= new DeleteLoanUseCase(loanRepository);
    }
    @AfterEach
    public void clear(){
        deleteLoanUseCase=null;
    }

    @Test
    public void reciboUnIdYBorroAlUsuarioConLaId(){
        //Given
        String idDelete="1";
        //When
        deleteLoanUseCase.execute(idDelete);
        //Then
        Mockito.verify(loanRepository,Mockito.times(1)).deleteLoan(idDelete);
    }

}