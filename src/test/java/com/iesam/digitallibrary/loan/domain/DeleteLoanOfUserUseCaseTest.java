package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DeleteLoanOfUserUseCaseTest {
    @Mock
    LoanRepository loanRepository;

    @Mock
    UserRepository userRepository;

    DeleteLoanOfUserUseCase deleteLoanOfUserUseCase;

    @BeforeEach
    public void setUp(){
        deleteLoanOfUserUseCase= new DeleteLoanOfUserUseCase(loanRepository,userRepository);
    }

    @Test
    public void meDanUnIdYLoBorro(){
        String idLoanDelete="1";
        ArrayList<Loan> loansExpected= new ArrayList<>();
        Loan loan=new Loan("1","001","1");
        Collections.addAll(loansExpected,new Loan("2","001","2"),loan);
        User user= new User("001","1","juan","camilo@camilo","617929803","calle",loansExpected);
        Mockito.when(loanRepository.obtainSpecifiedLoan(idLoanDelete)).thenReturn(loan);
        Mockito.when(userRepository.getUser(loan.idUser)).thenReturn(user);

        deleteLoanOfUserUseCase.execute(idLoanDelete);

        Mockito.verify(loanRepository,Mockito.times(1)).obtainSpecifiedLoan(idLoanDelete);
        Mockito.verify(userRepository,Mockito.times(1)).getUser(loan.idUser);
        Mockito.verify(userRepository,Mockito.times(1)).modifyUser(any(User.class));
    }

}