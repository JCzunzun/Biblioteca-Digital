package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

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
    public void meDanUnIdYModificoElPrestamo() {
        // Given
        String idModi = "2";
        Loan loan = new Loan("2", "001", "1");
        Mockito.when(loanRepository.obtainSpecifiedLoan(idModi)).thenReturn(loan);

        // When
        endedLoanUseCase.execute(idModi);

        // Then
        Mockito.verify(loanRepository, Mockito.times(1)).obtainSpecifiedLoan(idModi);
        Mockito.verify(loanRepository, Mockito.times(1)).deleteLoan(idModi);
        Mockito.verify(loanRepository, Mockito.times(1)).createLoan(any(Loan.class));
    }
}